package jobOpening.domain.jobOpeningAttributes;

import jakarta.persistence.Embeddable;

@Embeddable
public class JobReference {

    private String reference;

    public JobReference(String reference) {
        if (!validateReference(reference)) {
            throw new IllegalArgumentException("Reference not valid.");
        }
        this.reference = reference;
    }

    public JobReference() {
        // Required by JPA
    }

    private boolean validateReference(String reference) {
        return reference != null && !reference.isEmpty() && reference.length() <= 10;
    }

    @Override
    public String toString() {
        return reference;
    }

}
