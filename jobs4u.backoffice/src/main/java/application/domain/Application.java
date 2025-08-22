package application.domain;

import candidate.domain.Candidate;
import jakarta.persistence.*;
import jobOpening.domain.JobOpening;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Application implements Comparable<Interview> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ApplicationID")
    private Long id;

    @Getter
    @ManyToOne()
    @JoinColumn(name = "job_offer_id", nullable = false)
    private JobOpening jobOffer;

    @Embedded
    @Setter
    @Getter
    private Interview interview;

    @Embedded
    @Getter
    @Setter
    private ScreeningResult screeningResult = new ScreeningResult();

    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "application_files", joinColumns = @JoinColumn(name = "application_id"))
    @Column(nullable = false)
    private List<File> file;

    @Setter
    @Getter
    private File requirementsFile;

    @Getter
    @ManyToOne()
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    protected Application() {
        // ORM
    }

    public Application(JobOpening jobOffer, Interview interview, Candidate candidate, List<File> file) {
        this.jobOffer = jobOffer;
        this.interview = interview;
        this.candidate = candidate;
        this.file = file;
    }

    public Application(JobOpening jobOffer, Candidate candidate, List<File> file) {
        // TODO VERIFICAR INTERVIEW
        this.jobOffer = jobOffer;
        this.interview = null;
        this.candidate = candidate;
        this.file = file;
    }


    public boolean isApproved() {
        return this.screeningResult.getValue() == 1;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Application{");
        sb.append(", JobOffer:").append(jobOffer);
        sb.append(", Candidate:").append(candidate);
        sb.append(", ScreeningResult:").append(screeningResult.retrieveDescription());
        sb.append("\n, Interview :'").append(interview).append('\'');
        sb.append("\n, Files:'").append(file).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Interview o) {

        if (this.interview.getInterviewResult() == o.getInterviewResult()) {
            return 0;
        } else if (this.interview.getInterviewResult() > o.getInterviewResult()) {
            return -1;
        } else return 1;
    }

    public void uploadInterviewAnswers(String file) {
        interview.setIntervAnswersFile(file);
    }

    public void uploadInterviewGrade(double grade) {
        interview.setInterviewResult(grade);
    }
}
