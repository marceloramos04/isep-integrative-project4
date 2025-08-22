
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class us3000 {

    // Method to get candidate applications
    public List<ApplicationInfo> getCandidateApplications(Connection connection, int candidateId) throws SQLException {
        List<ApplicationInfo> applications = new ArrayList<>();
        List<Notification> notifications = new ArrayList<>();

        String query = "SELECT a.APPLICATIONID, j.JOB_TITLE, a.SCREENING_RESULT, " +
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
                    int applicationCount = resultSet.getInt("APPLICATION_COUNT");

                    applications.add(new ApplicationInfo(jobTitle, screeningResult, applicationCount));

                    // Update application tracking table and notify if needed
                    Notification notification = updateApplicationTracking(connection, applicationId, screeningResult, candidateId, jobTitle);
                    if (notification != null) {
                        notifications.add(notification);
                    }
                }
            }
        }

        // Print all notifications for debugging
        for (Notification notification : notifications) {
            System.out.println(notification);
        }

        return applications;
    }

    // Method to update the application tracking table and notify if there are changes
    private Notification updateApplicationTracking(Connection connection, long applicationId, int screeningResult, long candidateId, String jobTitle) throws SQLException {
        String selectQuery = "SELECT SCREENING_RESULT FROM APPLICATION_TRACKING WHERE APPLICATIONID = ?";
        String insertQuery = "INSERT INTO APPLICATION_TRACKING (APPLICATIONID, SCREENING_RESULT, LAST_UPDATED) VALUES (?, ?, ?)";
        String updateQuery = "UPDATE APPLICATION_TRACKING SET SCREENING_RESULT = ?, LAST_UPDATED = ? WHERE APPLICATIONID = ?";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
            selectStmt.setLong(1, applicationId);

            try (ResultSet resultSet = selectStmt.executeQuery()) {
                if (resultSet.next()) {
                    int oldScreeningResult = resultSet.getInt("SCREENING_RESULT");

                    if (oldScreeningResult != screeningResult) {
                        // Create notification only for specific SCREENING_RESULT values
                        String notificationText = null;
                        if (screeningResult == 1) {
                            notificationText = "Congratulations! You passed the screening phase for the job offer: " + jobTitle + " at " + new Timestamp(System.currentTimeMillis());
                        } else if (screeningResult == 0) {
                            notificationText = "We regret to inform you that you were rejected in the screening phase for the job offer: " + jobTitle + " at " + new Timestamp(System.currentTimeMillis());
                        }

                        if (notificationText != null) {
                            Notification notification = new Notification(applicationId, candidateId, notificationText, 0);

                            // Update the tracking table with new values
                            try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                                updateStmt.setInt(1, screeningResult);
                                updateStmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                                updateStmt.setLong(3, applicationId);
                                updateStmt.executeUpdate();
                            }

                            return notification;
                        }
                    }
                } else {
                    // Insert new record if it doesn't exist
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                        insertStmt.setLong(1, applicationId);
                        insertStmt.setInt(2, screeningResult);
                        insertStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                        insertStmt.executeUpdate();
                    }
                }
            }
        }

        return null;
    }
}
