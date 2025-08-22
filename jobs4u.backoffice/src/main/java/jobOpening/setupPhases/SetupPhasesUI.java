package jobOpening.setupPhases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class SetupPhasesUI implements Runnable {

    @Autowired
    private SetupPhasesController setupPhasesController;

    private LocalDate applicationStart, applicationEnd, screeningStart, screeningEnd, interviewsStart, interviewsEnd, analysisStart, analysisEnd, resultsStart, resultsEnd;

    @Override
    public void run() {

        //to do part of getting user Id to select job openings for the user
        if (setupPhasesController.getJobOpeningsToSetup().isEmpty()) {
            System.out.println("No job openings available to setup phases\n\nExiting setup phases...\n");
            return;
        }

        System.out.println("Listing Job Openings\n");
        int input;
        while (true) {
            // Show job openings
            input = Utils.showAndSelectIndex(setupPhasesController.getJobOpeningsToSetup(), "Select a job opening to setup phases for: \n") + 1;
            if (input == 0) {
                System.out.println("Exiting setup phases...");
                break;
            } else if (setupPhasesController.jobOpeningExists(input)) {
                try {
                    askForDates();
                    setupPhasesController.setupPhases(input, applicationStart, applicationEnd, screeningStart, screeningEnd, interviewsStart, interviewsEnd, analysisStart, analysisEnd, resultsStart, resultsEnd);
                    System.out.println("Phases setup successfully");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else System.out.println("Invalid option, please select a valid job opening number\n");
        }
    }

    /**
     * This method asks for the dates in order to up the phases for the selected job opening, and then asks the controller to set them up
     */
    private void askForDates() throws ParseException {
        System.out.println("Setting up phases for the selected job opening, make sure the dates are in order : ");

        // Application phase
        while (true){
            applicationStart = Utils.readLocalDateFromConsole("Enter the application phase start date : ");
            if (!applicationStart.isAfter(LocalDate.now().minusDays(1))) {
                System.out.println("The start date must be after today's date\nInput a valid date\n");
            } else break;
        }

        while (true){
            applicationEnd = Utils.readLocalDateFromConsole("Enter the application phase end date : ");
            if (!applicationEnd.isAfter(applicationStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Screening phase
        while (true){
            screeningStart = Utils.readLocalDateFromConsole("Enter the screening phase start date : ");
            if (!screeningStart.isAfter(applicationEnd.minusDays(1))) {
                System.out.println("The start date must be after the application phase end date\nInput a valid date\n");
            } else break;
        }

        while (true){
            screeningEnd = Utils.readLocalDateFromConsole("Enter the screening phase end date : ");
            if (!screeningEnd.isAfter(screeningStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Interviews phase
        String answer = Utils.readLineFromConsole("Will this job opening have an interview phase? (y/n): ");
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y") || Objects.equals(answer, "yes") || Objects.equals(answer, "Yes") || Objects.equals(answer, "YES")) {
            while (true){
                interviewsStart = Utils.readLocalDateFromConsole("Enter the interviews phase start date (dd-mm-yyyy): ");
                if (!interviewsStart.isAfter(screeningEnd.minusDays(1))) {
                    System.out.println("The start date must be after the screening phase end date\nInput a valid date\n");
                } else break;
            }

            while (true){
                interviewsEnd = Utils.readLocalDateFromConsole("Enter the interviews phase end date : ");
                if (!interviewsEnd.isAfter(interviewsStart)) {
                    System.out.println("The end date must be after the start date\nInput a valid date\n");
                } else break;
            }

            while (true){
                analysisStart = Utils.readLocalDateFromConsole("Enter the analysis phase start date : ");
                if (!analysisStart.isAfter(interviewsEnd.minusDays(1))) {
                    System.out.println("The start date must be after the interviews phase end date\nInput a valid date\n");
                } else break;
            }
        } else {
            while (true){
                analysisStart = Utils.readLocalDateFromConsole("Enter the analysis phase start date : ");
                if (!analysisStart.isAfter(screeningEnd.minusDays(1))) {
                    System.out.println("The start date must be after the screening phase end date\nInput a valid date\n");
                } else break;
            }
        }

        while (true){
            analysisEnd = Utils.readLocalDateFromConsole("Enter the analysis phase end date : ");
            if (!analysisEnd.isAfter(analysisStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Results phase
        while (true){
            resultsStart = Utils.readLocalDateFromConsole("Enter the results phase start date : ");
            if (!resultsStart.isAfter(analysisEnd.minusDays(1))) {
                System.out.println("The start date must be after the analysis phase end date\nInput a valid date\n");
            } else break;
        }

        while (true){
            resultsEnd = Utils.readLocalDateFromConsole("Enter the results phase end date : ");
            if (!resultsEnd.isAfter(resultsStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }


    }
}
