import java.time.LocalDate;

public class PhaseInfo {
    private final String jobTitle;
    private final String currentPhase;
    private final String nextPhase;
    private final LocalDate nextPhaseDate;

    public PhaseInfo(String jobTitle, String currentPhase, String nextPhase, LocalDate nextPhaseDate) {
        this.jobTitle = jobTitle;
        this.currentPhase = currentPhase;
        this.nextPhase = nextPhase;
        this.nextPhaseDate = nextPhaseDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCurrentPhase() {
        return currentPhase;
    }

    public String getNextPhase() {
        return nextPhase;
    }

    public LocalDate getNextPhaseDate() {
        return nextPhaseDate;
    }

    public String getNotificationMessage() {
        return "The job offer \"" + jobTitle + "\" has transitioned from " + currentPhase + " to " + nextPhase + " phase at " + nextPhaseDate;
    }
}
