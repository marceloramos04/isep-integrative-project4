
import java.io.Serializable;

public class ApplicationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long applicationId;
    private String jobTitle;
    private String screeningResult;
    private int applicationCount;
    private int screening;
    private double interviewResult;

    public ApplicationInfo(String jobTitle, String screeningResult, int applicationCount) {
        this.jobTitle = jobTitle;
        this.screeningResult = screeningResult;
        this.applicationCount = applicationCount;
    }

    public ApplicationInfo(long applicationId, String jobTitle, int screening, double interviewResult, int applicationCount) {
        this.applicationId = applicationId;
        this.jobTitle = jobTitle;
        this.screening = screening;
        this.interviewResult = interviewResult;
        this.applicationCount = applicationCount;
    }

    public ApplicationInfo(String jobTitle, int screening, int applicationCount) {
        this.jobTitle = jobTitle;
        this.screening = screening;
        this.applicationCount = applicationCount;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getScreeningResult() {
        return screeningResult;
    }

    public int getApplicationCount(){
        return applicationCount;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public int getScreening() {
        return screening;
    }

    public double getInterviewResult() {
        return interviewResult;
    }

    public String getScreeningResultString(String screeningResult) {
        switch (screeningResult) {
            case "1":
                return "Accepted";
            case "0":
                return "Rejected";
            case "-1":
                return "Not Verified Yet";
            default:
                return "Unknown";
        }
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "jobTitle='" + jobTitle + '\'' +
                ", screeningResult='" + screeningResult + '\'' +
                ", applicationCount=" + applicationCount +
                '}';
    }
}
