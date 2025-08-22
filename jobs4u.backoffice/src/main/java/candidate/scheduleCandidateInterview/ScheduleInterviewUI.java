package candidate.scheduleCandidateInterview;

import application.domain.Application;
import application.domain.Interview;
import application.domain.InterviewStatus;
import application.domain.ScreeningResult;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;
import application.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ScheduleInterviewUI implements Runnable{

    @Autowired
    ScheduleInterviewController scheduleInterviewController;

    public void run(){

        String email = Utils.readLineFromConsole("Enter the email of the candidate: ");
        Candidate c = scheduleInterviewController.getCandidateIdByEmail(EmailAddress.valueOf(email));
        if(c == null){
            System.out.println("Candidate not found");
            return;
        }
        List<Application> candidateApps = scheduleInterviewController.getApplicationsByCandidateId(c.getId());
        if(candidateApps.isEmpty()){
            System.out.println("No applications found for this candidate");
            return;
        }
        List<Long> jobIds =new ArrayList<>();
        for(Application app : candidateApps){
            JobOpening jo = app.getJobOffer();
            if (!jobIds.contains(jo.getId()) && app.isApproved()){
                jobIds.add(jo.getId());
            }
           }

        List<JobOpening> jobOpenings = scheduleInterviewController.getJobOpenings(jobIds);
        List<JobOpening> toRemove = new ArrayList<>();
        for(JobOpening jo : jobOpenings){
            String phase = jo.getRecruitmentProcess().getActivePhase();
            if(!phase.equals("Screening phase")){
                toRemove.add(jo);
            }
        }

        jobOpenings.removeAll(toRemove);

        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i));
        }
        int choice = Utils.readIntegerFromConsole("Choose the job opening you want to schedule an interview for: ");
        JobOpening selectedJobOpening = jobOpenings.get(choice - 1);

        Application selectedApplication = null;
        for (Application app : candidateApps) {
            if (app.getJobOffer().getId().equals(selectedJobOpening.getId())) {
                selectedApplication = app;
                break;
            }
        }

        if (selectedApplication == null) {
            System.out.println("No matching application found for the selected job opening.");
            return;
        }

        LocalDate endDate = selectedJobOpening.getRecruitmentProcess().getInterviewPhase().getEnd();

        Interview interview = null;
        InterviewStatus is = InterviewStatus.Pending;
        while (true) {
            try {
                System.out.println("Date for interview must be before: " + Utils.formatLocalDate(endDate));
                LocalDate interviewDate = Utils.readLocalDateFromConsole("Enter the date for the interview: ");
                LocalTime interviewTime = Utils.readLocalTimeFromConsole("Enter the time for the interview: ");
                LocalDateTime interviewDateTime = interviewDate.atTime(interviewTime);


                interview = scheduleInterviewController.createInterview(interviewDateTime, endDate, is);

                System.out.println("Interview scheduled for: " + interviewDateTime.getDayOfWeek() +' '+ Utils.formatLocalDateTime(interviewDateTime));
                String confirmation = Utils.readLineFromConsole("Do you want to proceed with this date and time? (yes/no): ");
                if (!confirmation.equalsIgnoreCase("yes")) {
                    continue;
                }
                break;

            } catch (DateTimeParseException | ParseException e) {
                System.out.println("Invalid date or time format. Please enter the date in the format: YYYY-MM-DD and the time in the format: HH:MM");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

       scheduleInterviewController.saveApplication(selectedApplication, interview);

        System.out.println("Interview scheduled for a: " + interview.getInterviewDateTime().getDayOfWeek());
        System.out.println(interview);
        System.out.println("Interview scheduled successfully!");






    }




}

