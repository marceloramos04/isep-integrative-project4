import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class us3003 {

    public static boolean updateLastLoginByEmail(Connection connection, String email, LocalDateTime lastLogIn) throws SQLException {
        String updateQuery = "UPDATE CUSTOMER SET LAST_LOG_IN = ? WHERE email = ?";
        System.out.println("Executing query: " + updateQuery + " with values: " + lastLogIn + ", " + email); // Debugging
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, lastLogIn.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            preparedStatement.setString(2, email);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected); // Debugging
            return rowsAffected > 0;
        }
    }

    public static LocalDateTime getLastLogInByEmail(Connection connection, String email) throws SQLException {
        String selectQuery = "SELECT LAST_LOG_IN FROM CUSTOMER WHERE email = ?";
        System.out.println("Executing query: " + selectQuery + " with value: " + email); // Debugging
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String lastLogInStr = resultSet.getString("LAST_LOG_IN");
                if (lastLogInStr != null) {
                    LocalDateTime lastLogIn = LocalDateTime.parse(lastLogInStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    System.out.println("Current Time: " + lastLogIn); // Debugging
                    return lastLogIn;
                }
            } else {
                System.out.println("No record found for email: " + email); // Debugging
                return null;
            }
        }
        return null;
    }

    public static void getJobOpeningsByCustomerId(Connection connection, long customerId, String email) throws SQLException {
        String selectQuery = "SELECT ID, JOB_TITLE, ANALYSIS_START_DATE, ANALYSIS_END_DATE, APPLICATION_START_DATE, APPLICATION_END_DATE, INTERVIEW_START_DATE, INTERVIEW_END_DATE, RESULT_START_DATE, RESULT_END_DATE, SCREENING_START_DATE, SCREENING_END_DATE FROM JOB_OPENING WHERE COSTUMERID = ?";
        System.out.println("Executing query: " + selectQuery + " with value: " + customerId); // Debugging
        LocalDateTime initialLastLogIn = getLastLogInByEmail(connection, email); // Get initial last log in time
        boolean isFirstLogin = initialLastLogIn == null;

        if (isFirstLogin) {
            initialLastLogIn = LocalDateTime.now(); // Set to current time if this is the first login
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long jobId = resultSet.getLong("ID");
                PhaseInfo currentPhaseInfo = determineCurrentPhase(resultSet, initialLastLogIn.toLocalDate());
                System.out.println("Found job opening: Job ID=" + jobId + ", Current Phase=" + currentPhaseInfo.getCurrentPhase()); // Debugging
                storePhaseTransition(connection, jobId, currentPhaseInfo, customerId, isFirstLogin);
            }
        }
    }

    private static PhaseInfo determineCurrentPhase(ResultSet resultSet, LocalDate lastLogInDate) throws SQLException {
        String jobTitle = resultSet.getString("JOB_TITLE");
        LocalDate analysisStart = getLocalDate(resultSet, "ANALYSIS_START_DATE");
        LocalDate analysisEnd = getLocalDate(resultSet, "ANALYSIS_END_DATE");
        LocalDate applicationStart = getLocalDate(resultSet, "APPLICATION_START_DATE");
        LocalDate applicationEnd = getLocalDate(resultSet, "APPLICATION_END_DATE");
        LocalDate interviewStart = getLocalDate(resultSet, "INTERVIEW_START_DATE");
        LocalDate interviewEnd = getLocalDate(resultSet, "INTERVIEW_END_DATE");
        LocalDate resultStart = getLocalDate(resultSet, "RESULT_START_DATE");
        LocalDate resultEnd = getLocalDate(resultSet, "RESULT_END_DATE");
        LocalDate screeningStart = getLocalDate(resultSet, "SCREENING_START_DATE");
        LocalDate screeningEnd = getLocalDate(resultSet, "SCREENING_END_DATE");

        if (isWithinRange(lastLogInDate, analysisStart, analysisEnd)) {
            return new PhaseInfo(jobTitle, "ANALYSIS", "RESULT", analysisEnd);
        } else if (isWithinRange(lastLogInDate, applicationStart, applicationEnd)) {
            return new PhaseInfo(jobTitle, "APPLICATION", "SCREENING", applicationEnd);
        } else if (isWithinRange(lastLogInDate, interviewStart, interviewEnd)) {
            return new PhaseInfo(jobTitle, "INTERVIEW", "ANALYSIS", interviewEnd);
        } else if (isWithinRange(lastLogInDate, resultStart, resultEnd)) {
            return new PhaseInfo(jobTitle, "RESULT", "NO_ACTIVE_PHASE", resultEnd);
        } else if (isWithinRange(lastLogInDate, screeningStart, screeningEnd)) {
            return new PhaseInfo(jobTitle, "SCREENING", "INTERVIEW", screeningEnd);
        } else {
            return new PhaseInfo(jobTitle, "NO ACTIVE PHASE", null, null);
        }
    }

    public static List<Notifications> getAllNotifications(Connection connection) throws SQLException {
        String selectQuery = "SELECT ID,NOTIFICATION, IS_READ FROM NOTIFICATION";
        List<Notifications> notifications = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String notification = resultSet.getString("NOTIFICATION");
                int isRead = resultSet.getInt("IS_READ");
                notifications.add(new Notifications(id,notification, isRead));
            }
        }

        return notifications;
    }

    private static LocalDate getLocalDate(ResultSet resultSet, String columnLabel) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(columnLabel);
        return timestamp != null ? timestamp.toLocalDateTime().toLocalDate() : null;
    }

    private static boolean isWithinRange(LocalDate check, LocalDate start, LocalDate end) {
        return (check.isEqual(start) || check.isAfter(start)) && (check.isEqual(end) || check.isBefore(end));
    }

    private static void storePhaseTransition(Connection connection, long jobId, PhaseInfo phaseInfo, long customerId, boolean isFirstLogin) throws SQLException {
        String selectCurrentPhaseQuery = "SELECT CURRENT_PHASE FROM JOB_PHASE_TRANSITION WHERE JOB_OFFER_ID = ?";
        String mergeQuery = "MERGE INTO JOB_PHASE_TRANSITION AS target " +
                "USING (VALUES (?, ?, ?, ?)) AS source (JOB_OFFER_ID, CURRENT_PHASE, NEW_PHASE, TRANSITION_DATE) " +
                "ON target.JOB_OFFER_ID = source.JOB_OFFER_ID " +
                "WHEN MATCHED THEN " +
                "UPDATE SET CURRENT_PHASE = source.CURRENT_PHASE, NEW_PHASE = source.NEW_PHASE, TRANSITION_DATE = source.TRANSITION_DATE " +
                "WHEN NOT MATCHED THEN " +
                "INSERT (JOB_OFFER_ID, CURRENT_PHASE, NEW_PHASE, TRANSITION_DATE) " +
                "VALUES (source.JOB_OFFER_ID, source.CURRENT_PHASE, source.NEW_PHASE, source.TRANSITION_DATE)";

        try (PreparedStatement selectStatement = connection.prepareStatement(selectCurrentPhaseQuery)) {
            selectStatement.setLong(1, jobId);
            ResultSet resultSet = selectStatement.executeQuery();
            String existingPhase = null;
            if (resultSet.next()) {
                existingPhase = resultSet.getString("CURRENT_PHASE");
            }
            System.out.println(phaseInfo.getCurrentPhase());

            boolean phaseChanged = existingPhase != null && !existingPhase.equals(phaseInfo.getCurrentPhase());

            try (PreparedStatement mergeStatement = connection.prepareStatement(mergeQuery)) {
                mergeStatement.setLong(1, jobId);
                mergeStatement.setString(2, phaseInfo.getCurrentPhase());
                mergeStatement.setString(3, phaseInfo.getNextPhase());
                mergeStatement.setTimestamp(4, phaseInfo.getNextPhaseDate() != null ? Timestamp.valueOf(phaseInfo.getNextPhaseDate().atStartOfDay()) : null);

                int rowsAffected = mergeStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected); // Debugging

                if (!isFirstLogin && phaseChanged) {
                    sendNotification(connection, customerId, phaseInfo.getNotificationMessage());
                }
            }
        }
    }

    private static void sendNotification(Connection connection, long customerId, String message) throws SQLException {
        String insertNotificationQuery = "INSERT INTO NOTIFICATION (CUSTOMER_ID, NOTIFICATION, IS_READ) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertNotificationQuery)) {
            preparedStatement.setLong(1, customerId);
            preparedStatement.setString(2, message);
            preparedStatement.setInt(3, 0); // 0 means unread
            preparedStatement.executeUpdate();
        }
    }
}
