package jobOpening.editJobOpening;

import eapli.framework.general.domain.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.stereotype.Component;
import utils.PositiveInteger;
import utils.Utils;
import utils.domain.address.ZipCode;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class EditJobOpeningUI implements Runnable {

    LocalDate applicationStart, applicationEnd, screeningStart, screeningEnd, interviewsStart = null, interviewsEnd = null, analysisStart, analysisEnd, resultsStart, resultsEnd;

    @Autowired
    private EditJobOpeningController editJobOpeningController;

    public void run() {
        if (editJobOpeningController.listAllJobOpenings().isEmpty()) {
            System.out.println("There are no job openings to edit.");
            return;
        }
        int index = Utils.showAndSelectIndex(editJobOpeningController.listAllJobOpenings(), "Select the job opening you want to edit:");
        while (true) {
            if (index == -1) {
                System.out.println("Exiting...");
                return;
            } else {
                if (index < -1 || index > editJobOpeningController.listAllJobOpenings().size()) {
                    System.out.println("Invalid option.");
                } else {
                    System.out.println("Job opening selected: " + editJobOpeningController.listAllJobOpenings().get(index));
                    break;
                }
            }
            index = Utils.readIntegerFromConsole("Select the job opening you want to edit: ");
        }

        System.out.println("Possible fields to edit: ");
        System.out.println("1. Job Title");
        System.out.println("2. Job Type");
        System.out.println("3. Working Mode");
        System.out.println("4. Address");
        System.out.println("5. Company Name");
        System.out.println("6. Number of Vacancies");
        System.out.println("7. Job Description");
        System.out.println("8. Recruitment Process");
        System.out.println("0. Exit");
        int index2 = Utils.readIntegerFromConsole("Select the field you want to edit: ");
        while (true) {
            if (index2 == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                if (index2 < 0 || index2 > 8) {
                    System.out.println("Invalid option. Please select a number of the stated options.");
                } else {
                    break;
                }
            }
        }
        boolean valid;
        switch (index2) {
            case 1:
                System.out.println("Editing Job Title...");
                do {
                    valid = editJobOpeningController.editJobTitle(Utils.readLineFromConsole("Enter the new Job Title: "), index);
                } while (!valid);
                break;

            case 2:
                System.out.println("Editing Job Type...");
                System.out.println("Available Job Types: ");
                System.out.println("1. Full Time");
                System.out.println("2. Part Time");
                do {
                    valid = editJobOpeningController.editJobType(Utils.readLineFromConsole("Enter the new Job Type: "), index);
                } while (!valid);
                break;

            case 3:
                System.out.println("Editing Working Mode...");
                System.out.println("Available Working Modes: ");
                System.out.println("1. Remote");
                System.out.println("2. On site");
                System.out.println("3. Hybrid");
                do {
                    valid = editJobOpeningController.editWorkingMode(Utils.readLineFromConsole("Enter the new Working Mode: "), index);
                } while (!valid);
                break;

            case 4:
                System.out.println("Editing Address...");
                String city, street, zipCode;
                int buildingNumber;
                while (true) {
                    city = Utils.readLineFromConsole("Enter city : ");
                    if (Text.valueOf(city).wordCount() > 0) {
                        break;
                    }
                    System.out.println("Invalid address. Please try again.");
                }
                while (true) {
                    street = Utils.readLineFromConsole("Enter street : ");
                    if (Text.valueOf(street).wordCount() > 0) {
                        break;
                    }
                    System.out.println("Invalid address. Please try again.");
                }
                while (true) {
                    buildingNumber = Utils.readIntegerFromConsole("Enter building number : ");
                    if (PositiveInteger.isValid(buildingNumber)) {
                        break;
                    }
                    System.out.println("Invalid building number. Please try again.");
                }
                while (true) {
                    zipCode = Utils.readLineFromConsole("Enter zip code (1234-567): ");
                    if (ZipCode.checkZipCodeFormat(zipCode)) {
                        break;
                    }
                    System.out.println("Invalid address. Please try again.");
                }

                editJobOpeningController.editAddress(city, street, zipCode, buildingNumber, index);
                break;

            case 5:
                System.out.println("Editing Company Name...");

                do {
                    valid = editJobOpeningController.editCompanyName(Utils.readLineFromConsole("Enter the new Company Name: "), index);
                } while (!valid);
                break;

            case 6:
                System.out.println("Editing Number of Vacancies...");

                do {
                    valid = editJobOpeningController.editNumberVacancies(Utils.readPositiveIntegerFromConsole("Enter the new Number of Vacancies: "), index);
                } while (!valid);
                break;

            case 7:
                System.out.println("Editing Job Description...");

                do {
                    valid = editJobOpeningController.editJobDescription(Utils.readLineFromConsole("Enter the new Job Description: "), index);
                } while (!valid);
                break;

            case 8:
                System.out.println("Editing Recruitment Process...");
                try {
                    askForDates();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                editJobOpeningController.editRecruitmentProcess(applicationStart, applicationEnd, screeningStart, screeningEnd, interviewsStart, interviewsEnd, analysisStart, analysisEnd, resultsStart, resultsEnd, index);
                break;

        }


    }

    /**
     * This method asks for the dates in order to up the phases for the selected job opening, and then asks the controller to set them up
     */
    private void askForDates() throws ParseException {
        System.out.println("Setting up phases for the selected job opening, make sure the dates are in order : ");

        // Application phase
        while (true) {
            applicationStart = Utils.readLocalDateFromConsole("Enter the application phase start date : ");
            if (!applicationStart.isAfter(LocalDate.now().minusDays(1))) {
                System.out.println("The start date must be after today's date\nInput a valid date\n");
            } else break;
        }

        while (true) {
            applicationEnd = Utils.readLocalDateFromConsole("Enter the application phase end date : ");
            if (!applicationEnd.isAfter(applicationStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Screening phase
        while (true) {
            screeningStart = Utils.readLocalDateFromConsole("Enter the screening phase start date : ");
            if (!screeningStart.isAfter(applicationEnd.minusDays(1))) {
                System.out.println("The start date must be after the application phase end date\nInput a valid date\n");
            } else break;
        }

        while (true) {
            screeningEnd = Utils.readLocalDateFromConsole("Enter the screening phase end date : ");
            if (!screeningEnd.isAfter(screeningStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Interviews phase
        String answer = Utils.readLineFromConsole("Will this job opening have an interview phase? (y/n): ");
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y") || Objects.equals(answer, "yes") || Objects.equals(answer, "Yes") || Objects.equals(answer, "YES")) {
            while (true) {
                interviewsStart = Utils.readLocalDateFromConsole("Enter the interviews phase start date (dd-mm-yyyy): ");
                if (!interviewsStart.isAfter(screeningEnd.minusDays(1))) {
                    System.out.println("The start date must be after the screening phase end date\nInput a valid date\n");
                } else break;
            }

            while (true) {
                interviewsEnd = Utils.readLocalDateFromConsole("Enter the interviews phase end date : ");
                if (!interviewsEnd.isAfter(interviewsStart)) {
                    System.out.println("The end date must be after the start date\nInput a valid date\n");
                } else break;
            }

            while (true) {
                analysisStart = Utils.readLocalDateFromConsole("Enter the analysis phase start date : ");
                if (!analysisStart.isAfter(interviewsEnd.minusDays(1))) {
                    System.out.println("The start date must be after the interviews phase end date\nInput a valid date\n");
                } else break;
            }
        } else {
            while (true) {
                analysisStart = Utils.readLocalDateFromConsole("Enter the analysis phase start date : ");
                if (!analysisStart.isAfter(screeningEnd.minusDays(1))) {
                    System.out.println("The start date must be after the screening phase end date\nInput a valid date\n");
                } else break;
            }
        }

        while (true) {
            analysisEnd = Utils.readLocalDateFromConsole("Enter the analysis phase end date : ");
            if (!analysisEnd.isAfter(analysisStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }

        // Results phase
        while (true) {
            resultsStart = Utils.readLocalDateFromConsole("Enter the results phase start date : ");
            if (!resultsStart.isAfter(analysisEnd.minusDays(1))) {
                System.out.println("The start date must be after the analysis phase end date\nInput a valid date\n");
            } else break;
        }

        while (true) {
            resultsEnd = Utils.readLocalDateFromConsole("Enter the results phase end date : ");
            if (!resultsEnd.isAfter(resultsStart)) {
                System.out.println("The end date must be after the start date\nInput a valid date\n");
            } else break;
        }


    }

}
