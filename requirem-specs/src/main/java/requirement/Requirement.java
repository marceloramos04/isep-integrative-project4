package requirement;

import java.util.ArrayList;

public class Requirement {

    private String description;
    private RequiremType type;
    private String[] expected;
    private String[] possibleAnswers;
    private String comment;

    public Requirement(String description, RequiremType type, String[] expected, String[] possibleAnswers, String comment) {
        this.description = description;
        this.type = type;
        this.expected = expected;
        this.possibleAnswers = possibleAnswers;
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public RequiremType getType() {
        return type;
    }

    public String[] getExpected() {
        return expected;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public String getComment() {
        return comment;
    }
}
