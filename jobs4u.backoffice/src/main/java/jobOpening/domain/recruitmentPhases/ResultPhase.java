package jobOpening.domain.recruitmentPhases;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class ResultPhase {

    @Column(name = "RESULT_START_DATE")
    LocalDate start;

    @Column(name = "RESULT_END_DATE")
    LocalDate end;

    public ResultPhase(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    protected ResultPhase() {
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
        return "ResultPhase{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

}

