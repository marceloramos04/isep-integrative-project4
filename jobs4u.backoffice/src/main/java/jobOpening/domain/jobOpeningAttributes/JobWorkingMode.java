package jobOpening.domain.jobOpeningAttributes;

import jakarta.persistence.Embeddable;

@Embeddable
public class JobWorkingMode {

    private Mode mode;

    private enum Mode
    {
        REMOTE,
        ON_SITE,
        HYBRID
    }

    protected JobWorkingMode() {
        // ORM
    }

    public JobWorkingMode(int modeIndex) {
        if (modeIndex == 1) {
            this.mode = Mode.REMOTE;
        } else if (modeIndex == 2) {
            this.mode = Mode.ON_SITE;
        } else if (modeIndex == 3) {
            this.mode = Mode.HYBRID;
        } else {
            throw new IllegalArgumentException("Invalid mode");
        }
    }

    public static boolean isValid(int modeIndex) {
        return modeIndex == 1 || modeIndex == 2 || modeIndex == 3;
    }

    @Override
    public String toString() {
        if (mode == Mode.REMOTE) {
            return "Remote";
        } else if (mode == Mode.ON_SITE){
            return "On site";
        } else if (mode == Mode.HYBRID){
            return "Hybrid";
        } else {
            return null;
        }
    }
}
