package jobOpening.domain.recruitmentPhases;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;

@Embeddable
public class InterviewsPhase {

    @Column(name = "INTERVIEW_START_DATE")
    LocalDate start;

    @Getter
    @Column(name = "INTERVIEW_END_DATE")
    LocalDate end;


    public InterviewsPhase(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    protected InterviewsPhase() {
        // ORM
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return today.isAfter(start) && today.isBefore(end) || today.isEqual(start);
    }

    public void open(){
        this.start = LocalDate.now();
    }

    public void close(){
        this.end= LocalDate.now();
    }

    @Override
    public String toString() {
        if (start == null || end == null)
            return null;
        return "InterviewsPhase{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
