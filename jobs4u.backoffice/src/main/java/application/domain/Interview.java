package application.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
@Getter
@Setter
public class Interview  {

    private InterviewStatus status;
    private String intervAnswersFile;
    private LocalDateTime interviewDateTime;
    private double interviewResult;

    @Transient
    private final String INTERV_ANSWERS_FILE_DEFAULT= "No file uploaded";
    @Transient
    private final double INTERV_RESULT_DEFAULT=-1;
    @Transient
    private final InterviewStatus INTERV_STATUS_DEFAULT= InterviewStatus.NOT_INTERVIEWED;
    @Transient
    private final LocalDateTime INTERV_DATE_TIME_DEFAULT= LocalDateTime.now();

    public Interview(LocalDateTime interviewDateTime, LocalDate endDate, InterviewStatus code) {
        LocalDate interviewDate = interviewDateTime.toLocalDate();
        if (interviewDate.isAfter(LocalDate.now()) && interviewDate.isBefore(endDate)) {
            this.interviewDateTime = interviewDateTime;
            this.status = code;
            interviewResult = 0;
        } else {
            throw new IllegalArgumentException("The date must be in the future and before the end of the interview phase.");
        }

        intervAnswersFile = INTERV_ANSWERS_FILE_DEFAULT;
        interviewResult = INTERV_RESULT_DEFAULT;
    }

    public Interview(LocalDateTime interviewDateTime, LocalDate endDate, InterviewStatus code, int result) {
        LocalDate interviewDate = interviewDateTime.toLocalDate();
        if (interviewDate.isAfter(LocalDate.now()) && interviewDate.isBefore(endDate)) {
            this.interviewDateTime = interviewDateTime;
            this.status = code;
            interviewResult = result;
        } else {
            throw new IllegalArgumentException("The date must be in the future and before the end of the interview phase.");
        }
    }

    public Interview() {
        intervAnswersFile = INTERV_ANSWERS_FILE_DEFAULT;
        interviewResult = INTERV_RESULT_DEFAULT;
        status = INTERV_STATUS_DEFAULT;
        interviewDateTime = INTERV_DATE_TIME_DEFAULT;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");
        String formattedDateTime = interviewDateTime.format(formatter);

        return "Interview{" +
                "status=" + status +
                ", interviewDate=" + formattedDateTime +
                ", interviewResult=" + interviewResult +
                '}';
    }

}