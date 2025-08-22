package jobOpening.domain.jobOpeningAttributes;

import jakarta.persistence.Embeddable;

@Embeddable
public class JobType {

    private Type type;

    private enum Type
    {
        FULL_TIME,
        PART_TIME
    }

    protected JobType() {
        // ORM
    }

    public JobType(int typeIndex) {
        if (typeIndex == 1) {
            this.type = Type.FULL_TIME;
        } else if (typeIndex == 2) {
            this.type = Type.PART_TIME;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public static boolean isValid(int typeIndex) {
        return typeIndex== 1 || typeIndex == 2;
    }

    @Override
    public String toString() {
        if (type == Type.FULL_TIME) {
            return "Full time";
        } else if (type == Type.PART_TIME){
            return "Part time";
        } else {
            return null;
        }
    }
}
