package application.domain;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class InterviewResult implements ValueObject {


    @Column(name = "interview_result")
    private InterviewStatus interviewStatus;


    public InterviewResult() {
        interviewStatus=InterviewStatus.NOT_INTERVIEWED;
    }

    public InterviewResult(InterviewStatus interviewStatus) {
        this.interviewStatus=interviewStatus;
    }

    public InterviewStatus retrieveInterviewStatus() {
        return interviewStatus;
    }

    public void updateInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewResult that = (InterviewResult) o;
        return Objects.equals(interviewStatus, that.interviewStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(interviewStatus);
    }

    @Override
    public String toString() {
        return "InterviewResult{" +
                "interviewStatus=" + interviewStatus.retrieveDescription() +
                '}';
    }
}