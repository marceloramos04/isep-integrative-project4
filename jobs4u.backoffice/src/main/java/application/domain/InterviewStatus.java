package application.domain;

import lombok.Setter;

import java.time.LocalDate;

public enum InterviewStatus {
    NOT_INTERVIEWED(0, "Not Interviewed"),
    Accepted(1, "Accepted"),
    Rejected(2, "Rejected"),
    Pending(3, "Pending");

    private final int code;
    private final String description;

    InterviewStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int retrieveCode() {
        return code;
    }

    public String retrieveDescription() {
        return description;
    }
}