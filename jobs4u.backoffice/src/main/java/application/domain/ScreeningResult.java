package application.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ScreeningResult {

    public static final ScreeningResult ACCEPTED = new ScreeningResult(1);
    public static final ScreeningResult REJECTED = new ScreeningResult(0);
    public static final ScreeningResult NOT_VERIFIED_YET = new ScreeningResult(-1);

    @Column(name = "screening_result")
    private int value;

    protected ScreeningResult() {
        value = -1;
    }

    public ScreeningResult(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningResult that = (ScreeningResult) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public String retrieveDescription() {
        switch (this.value) {
            case 1:
                return "Accepted";
            case 0:
                return "Rejected";
            case -1:
                return "Not Verified Yet";
            default:
                return "Unknown";
        }
    }


}

