package jobOpening.domain.jobOpeningAttributes;

import eapli.framework.general.domain.model.Text;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyName {

    private String companyName;

    protected CompanyName() {
        // for ORM
    }

    public CompanyName(String companyName) {
        if (Text.valueOf(companyName).wordCount() < 1 ) {
            throw new IllegalArgumentException("Invalid company name");
        } else
            this.companyName = companyName;
    }

    public static boolean isValid(String companyName) {
        try {
            return Text.valueOf(companyName).wordCount() > 0;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return companyName;
    }

}
