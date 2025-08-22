package jobOpening.domain.jobOpeningAttributes;

import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import jobOpening.domain.recruitmentPhases.*;
import lombok.Getter;

@Embeddable
public class RecruitmentProcess {

    @Getter
    private ApplicationPhase applicationPhase;

    private ScreeningPhase screeningPhase;

    @Getter
    private InterviewsPhase interviewPhase;

    private AnalysisPhase analysisPhase;

    private ResultPhase resultPhase;

    protected RecruitmentProcess() {
        // ORM
    }

    public RecruitmentProcess(ApplicationPhase applicationPhase, ScreeningPhase screeningPhase, @Nullable InterviewsPhase interviewPhase, AnalysisPhase evaluationPhase, ResultPhase resultPhase) {
        this.applicationPhase = applicationPhase;
        this.screeningPhase = screeningPhase;
        this.interviewPhase = interviewPhase;
        this.analysisPhase = evaluationPhase;
        this.resultPhase = resultPhase;
    }

    public String getActivePhase() {
        if (resultPhase.isActive()) {
            return "Result phase";
        } else if (analysisPhase.isActive()) {
            return "Analysis phase";
        } else if (interviewPhase != null && interviewPhase.isActive()) {
            return "Interview phase";
        } else if (screeningPhase.isActive()) {
            return "Screening phase";
        } else if (applicationPhase.isActive()) {
            return "Application phase";
        } else {
            return null;
        }
    }

    public String closeActivePhase() {
        switch (getActivePhase()) {
            case "Application phase":
                applicationPhase.close();
                screeningPhase.open();
                return "Closed application phase. Opened screening phase.";

            case "Screening phase":
                screeningPhase.close();
                if (interviewPhase != null) {
                    interviewPhase.open();
                    return "Closed screening phase. Opened interview phase.";
                } else {
                    analysisPhase.open();
                    return "Closed screening phase. Opened analysis phase.";
                }

            case "Interview phase":
                interviewPhase.close();
                analysisPhase.open();
                return "Closed interview phase. Opened analysis phase.";

            case "Analysis phase":
                analysisPhase.close();
                resultPhase.open();
                return "Closed analysis phase. Opened result phase.";

            case "Result phase":
                resultPhase.close();
                return "Closed result phase.";
        }
        return "No active phase to close.";
    }

    @Override
    public String toString() {
        return "RecruitmentProcess{" +
                applicationPhase +
                screeningPhase +
                interviewPhase +
                analysisPhase +
                resultPhase +
                '}';
    }
}
