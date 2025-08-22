package jobOpening.setupPhases;

import jakarta.annotation.Nullable;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import jobOpening.domain.recruitmentPhases.*;
import jobOpening.domain.jobOpeningAttributes.RecruitmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SetupPhasesService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public JobOpening setupPhases(long jobOpeningIndex, LocalDate applicationDateStart, LocalDate applicationDateEnd, LocalDate screeningDateStart, LocalDate screeningDateEnd, @Nullable LocalDate interviewsDateStart, @Nullable LocalDate interviewsDateEnd, LocalDate analysisDateStart, LocalDate analysisDateEnd, LocalDate resultDateStart, LocalDate resultDateEnd) {
        JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningIndex);

        ApplicationPhase applicationPhase = new ApplicationPhase(applicationDateStart, applicationDateEnd);
        ScreeningPhase screeningPhase = new ScreeningPhase(screeningDateStart, screeningDateEnd);
        InterviewsPhase interviewsPhase = new InterviewsPhase(interviewsDateStart, interviewsDateEnd);
        AnalysisPhase analysisPhase = new AnalysisPhase(analysisDateStart, analysisDateEnd);
        ResultPhase resultPhase = new ResultPhase(resultDateStart, resultDateEnd);

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(applicationPhase, screeningPhase, interviewsPhase, analysisPhase, resultPhase);

        jobOpening.setupPhases(recruitmentProcess);

        return jobOpening;
    }

}
