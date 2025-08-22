import java.io.Serializable;
import java.time.LocalDate;

public class JobOpeningInfo implements Serializable {
    String id;
    String jobTitle;
    LocalDate activateSince;
    Integer noOfApplications;

    public JobOpeningInfo(String id, String jobTitle, LocalDate activateSince, Integer noOfApplications) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.activateSince = activateSince;
        this.noOfApplications = noOfApplications;
    }

    public String getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getActivateSince() {
        return activateSince;
    }

    public Integer getNoOfApplications() {
        return noOfApplications;
    }

    public void setNoOfApplications(Integer noOfApplications) {
        this.noOfApplications = noOfApplications;
    }
}
