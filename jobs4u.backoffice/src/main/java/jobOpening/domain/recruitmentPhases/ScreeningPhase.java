package jobOpening.domain.recruitmentPhases;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;

@Embeddable
public class ScreeningPhase {

    @Column(name = "SCREENING_START_DATE")
    LocalDate start;

    @Getter
    @Column(name = "SCREENING_END_DATE")
    LocalDate end;

    public ScreeningPhase(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    protected ScreeningPhase() {
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
        return "ScreeningPhase{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

}
