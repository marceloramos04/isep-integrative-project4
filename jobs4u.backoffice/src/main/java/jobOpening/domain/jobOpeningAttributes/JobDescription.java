package jobOpening.domain.jobOpeningAttributes;

import eapli.framework.general.domain.model.Text;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobDescription {

    private String jobDescription;

    protected JobDescription() {
        // for ORM
    }

    public JobDescription(String jobDescription) {
        if (Text.valueOf(jobDescription).wordCount() < 1) {
            throw new IllegalArgumentException("Invalid job description");
        } else
            this.jobDescription = jobDescription;
    }

    public static boolean isValid(String jobDescription) {
        try {
            return Text.valueOf(jobDescription).wordCount() > 1;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return jobDescription;
    }

}
