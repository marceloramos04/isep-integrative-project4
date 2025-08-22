package jobOpening.domain.jobOpeningAttributes;

import eapli.framework.general.domain.model.Text;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobTitle {

    private String jobTitle;

    protected JobTitle() {
        // for ORM
    }

    public JobTitle(String jobTitle) {
        if (Text.valueOf(jobTitle).wordCount() < 1 ) {
            throw new IllegalArgumentException("Invalid job title");
        } else
            this.jobTitle = jobTitle;
    }

    public static boolean isValid(String jobTitle) {
        try {
            return Text.valueOf(jobTitle).wordCount() > 0;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return jobTitle;
    }

}
