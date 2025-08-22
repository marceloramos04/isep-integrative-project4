import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class us3002 {

    public static List<JobOpeningInfo> getJobOpeningsInfoByCustomerId(Connection connection, long customerId) throws SQLException {
        String selectQuery = "SELECT ID, REFERENCE, JOB_TITLE, APPLICATION_START_DATE, " +
                "(SELECT COUNT(*) FROM APPLICATION WHERE JOB_OFFER_ID = JOB_OPENING.ID) AS APPLICATION_COUNT " +
                "FROM JOB_OPENING WHERE COSTUMERID = ?";
        System.out.println("Executing query: " + selectQuery + " with value: " + customerId); // Debugging

        List<JobOpeningInfo> jobOpenings = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String reference = resultSet.getString("REFERENCE");
                String jobTitle = resultSet.getString("JOB_TITLE");
                LocalDate applicationStartDate = resultSet.getTimestamp("APPLICATION_START_DATE").toLocalDateTime().toLocalDate();
                int applicationCount = resultSet.getInt("APPLICATION_COUNT");

                jobOpenings.add(new JobOpeningInfo(reference, jobTitle, applicationStartDate, applicationCount));
            }
        }
        return jobOpenings;
    }
}
