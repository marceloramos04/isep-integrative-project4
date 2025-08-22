package jobOpening.domain.recruitmentPhases;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class AnalysisPhase {

    @Column(name = "ANALYSIS_START_DATE")
    LocalDate start;

    @Column(name = "ANALYSIS_END_DATE")
    LocalDate end;

    public AnalysisPhase(LocalDate analysisStart, LocalDate analysisEnd) {
        this.start = analysisStart;
        this.end = analysisEnd;
    }

    protected AnalysisPhase() {
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
        return "AnalysisPhase{" +
                "analysisStart=" + start +
                ", analysisEnd=" + end +
                '}';
    }

}

