import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class us3001 {

    public static List<ApplicationInfo> getCandidateApplications(Connection connection, int candidateId) throws SQLException {
        List<ApplicationInfo> applications = new ArrayList<>();

        String query = "SELECT a.APPLICATIONID, j.JOB_TITLE, a.SCREENING_RESULT, a.INTERVIEW_RESULT, " +
                "(SELECT COUNT(*) FROM APPLICATION WHERE JOB_OFFER_ID = a.JOB_OFFER_ID) AS APPLICATION_COUNT " +
                "FROM APPLICATION a " +
                "INNER JOIN JOB_OPENING j ON a.JOB_OFFER_ID = j.ID " +
                "WHERE a.CANDIDATE_ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, candidateId);
            System.out.println("Executing query: " + preparedStatement.toString()); // Debugging: Print the executed query

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    long applicationId = resultSet.getLong("APPLICATIONID");
                    String jobTitle = resultSet.getString("JOB_TITLE");
                    int screeningResult = resultSet.getInt("SCREENING_RESULT");
                    double interviewResult = resultSet.getDouble("INTERVIEW_RESULT");
                    int applicationCount = resultSet.getInt("APPLICATION_COUNT");

                    applications.add(new ApplicationInfo(applicationId, jobTitle, screeningResult, interviewResult, applicationCount));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return applications;
    }


    public static List<Notification> updateApplicationTrackingAndNotify(Connection connection, List<ApplicationInfo> applications, long candidateId) throws SQLException {
        List<Notification> notifications = new ArrayList<>();

        for (ApplicationInfo application : applications) {
            Notification notification = updateApplicationTracking(connection, application, candidateId);
            if (notification != null) {
                notifications.add(notification);
            }
        }

        for (Notification notification : notifications) {
            System.out.println(notification);
        }

        return notifications;
    }

    private static Notification updateApplicationTracking(Connection connection, ApplicationInfo application, long candidateId) throws SQLException {
        String selectQuery = "SELECT SCREENING_RESULT, INTERVIEW_RESULT FROM APPLICATION_TRACKING WHERE APPLICATIONID = ?";
        String insertQuery = "INSERT INTO APPLICATION_TRACKING (APPLICATIONID, SCREENING_RESULT, INTERVIEW_RESULT, LAST_UPDATED) VALUES (?, ?, ?, ?)";
        String updateQuery = "UPDATE APPLICATION_TRACKING SET SCREENING_RESULT = ?, INTERVIEW_RESULT = ?, LAST_UPDATED = ? WHERE APPLICATIONID = ?";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
            selectStmt.setLong(1, application.getApplicationId());

            try (ResultSet resultSet = selectStmt.executeQuery()) {
                if (resultSet.next()) {
                    int oldScreeningResult = resultSet.getInt("SCREENING_RESULT");
                    double oldInterviewResult = resultSet.getDouble("INTERVIEW_RESULT");

                    if (oldScreeningResult != application.getScreening() || oldInterviewResult != application.getInterviewResult()) {
                        String notificationText = "Job offer for " + application.getJobTitle() + " has changed. Screening Result: " + oldScreeningResult + " -> " + application.getScreeningResult() + ", Interview Result: " + oldInterviewResult + " -> " + application.getInterviewResult() + " at " + new Timestamp(System.currentTimeMillis());
                        Notification notification = new Notification(application.getApplicationId(), candidateId, notificationText, 0);

                        try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                            updateStmt.setInt(1, application.getScreening());
                            updateStmt.setDouble(2, application.getInterviewResult());
                            updateStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                            updateStmt.setLong(4, application.getApplicationId());
                            updateStmt.executeUpdate();
                        }

                        return notification;
                    }
                } else {

                    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                        insertStmt.setLong(1, application.getApplicationId());
                        insertStmt.setInt(2, application.getScreening());
                        insertStmt.setDouble(3, application.getInterviewResult());
                        insertStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                        insertStmt.executeUpdate();
                    }
                }
            }
        }

        return null;
    }
}
