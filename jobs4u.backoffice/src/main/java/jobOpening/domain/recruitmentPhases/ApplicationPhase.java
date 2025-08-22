package jobOpening.domain.recruitmentPhases;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class ApplicationPhase {

    @Column(name = "APPLICATION_START_DATE")
    LocalDate start;

    @Column(name = "APPLICATION_END_DATE")
    LocalDate end;

    public ApplicationPhase(LocalDate applicationStart, LocalDate applicationEnd) {
        this.start = applicationStart;
        this.end = applicationEnd;
    }

    protected ApplicationPhase() {
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
        return "ApplicationPhase{" +
                "applicationStart=" + start +
                ", applicationEnd=" + end +
                '}';
    }

}
