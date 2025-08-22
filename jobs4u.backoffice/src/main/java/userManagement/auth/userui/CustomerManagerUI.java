package userManagement.auth.userui;

import application.grade_interviews.GradeIntervUI;
import application.list_application_data.ListApplicationDataUI;
import application.listapplications.ListApplicationsForJobOfferUI;
import application.use_cases.upload_interv_answers.UploadInterviewAnswersUI;
import candidate.ListAllCandidates.ListAllCandidatesUI;
import candidate.ListCandidateData.ListCandidateDataUI;
import candidate.RegisterCandidate.RegisterCandidateUI;
import candidate.RetrieveCandidatesOrderedList.RetrieveCandidatesOrderedListUI;
import candidate.scheduleCandidateInterview.ScheduleInterviewUI;
import customer.use_cases.register_customer.RegisterCustomerUI;
import jobOpening.addRanking.AddRankingUI;
import jobOpening.closePhase.ClosePhaseUI;
import jobOpening.editJobOpening.EditJobOpeningUI;
import jobOpening.listJobOpenings.ListJobOpeningUI;
import jobOpening.registerJobOpening.RegisterJobOpeningUI;
import jobOpening.requirementVerification.VerificationRequirementsController;
import jobOpening.requirementVerification.VerificationRequirementsUI;
import jobOpening.setupPhases.SetupPhasesUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

@Component
public class CustomerManagerUI implements Runnable {

    @Autowired
    private RegisterCandidateUI registerCandidateUI;

    @Autowired
    private ListCandidateDataUI listCandidateDataUI;

    @Autowired
    private ListAllCandidatesUI listAllCandidatesUI;

    @Autowired
    private RegisterJobOpeningUI registerJobOpeningUI;

    @Autowired
    private ListJobOpeningUI listJobOpeningUI;

    @Autowired
    private ListApplicationsForJobOfferUI listApplicationsForJobOfferUI;

    @Autowired
    private SetupPhasesUI setupPhasesUI;

    @Autowired
    private RegisterCustomerUI registerCustomerUI;

    @Autowired
    private ListApplicationDataUI listApplicationDataUI;

    @Autowired
    private AddRankingUI addRankingUI;

    @Autowired
    private ClosePhaseUI closePhaseUI;

    @Autowired
    private ScheduleInterviewUI scheduleInterviewUI;

    @Autowired
    private EditJobOpeningUI editJobOpeningUI;

    @Autowired
    private UploadInterviewAnswersUI uploadInterviewAnswersUI;

    @Autowired
    private VerificationRequirementsUI verificationRequirementsUI;

    @Autowired
    private GradeIntervUI gradeIntervUI;

    @Autowired
    private RetrieveCandidatesOrderedListUI retrieveCandidatesOrderedListUI;

    @Override
    public void run() {

        boolean exit = false;

        while (!exit) {

            System.out.println("======Welcome to the Customer Manager UI======\n");

            System.out.println("1 - Register Candidate");
            System.out.println("2 - Register new Job Opening");
            System.out.println("3 - List Job Openings");
            System.out.println("4 - Setup Job Opening's Phases");
            System.out.println("5 - List a Candidate");
            System.out.println("6 - List all Candidates");
            System.out.println("7 - List Applications for a Job Opening");
            System.out.println("8 - Register Customer");
            System.out.println("9 - List Application Data");
            System.out.println("10 - Add Ranking to Candidates for a Job Opening");
            System.out.println("11 - Close active phase of a Job Opening");
            System.out.println("12 - Schedule a Interview for a Candidate");
            System.out.println("13 - Edit a job opening");
            System.out.println("14 - Upload interview answers for an application");
            System.out.println("15 - Verify that the applications met the requirements, for a job opening");
            System.out.println("16 - Start the Process of Grading Interviews for a Job Opening");
            System.out.println("17 - List candidates by their interview points");
            System.out.println("0 - Exit");

            System.out.println();

            switch (Utils.readIntegerFromConsole("Enter the number of the option you want to choose:")) {

                case 0:
                    exit = true;
                    break;

                case 1:
                    registerCandidateUI.run();
                    break;

                case 2:
                    registerJobOpeningUI.run();
                    break;

                case 3:
                    listJobOpeningUI.run();
                    break;

                case 4:
                    setupPhasesUI.run();
                    break;

                case 5:
                    listCandidateDataUI.run();
                    break;

                case 6:
                    listAllCandidatesUI.run();
                    break;

                case 7:
                    listApplicationsForJobOfferUI.run();
                    break;

                case 8:
                    registerCustomerUI.run();
                    break;

                case 9:
                    listApplicationDataUI.run();
                    break;

                case 10:
                    addRankingUI.run();
                    break;

                case 11 :
                    closePhaseUI.run();
                    break;

                case 12:
                    scheduleInterviewUI.run();
                    break;

                case 13:
                    editJobOpeningUI.run();
                    break;

                case 14:
                    uploadInterviewAnswersUI.run();
                    break;

                case 15:
                    verificationRequirementsUI.run();
                    break;

                case 16:
                    gradeIntervUI.run();
                    break;

                case 17:
                    retrieveCandidatesOrderedListUI.run();
                    break;

                default:
                    System.err.println("INVALID OPTION");
                    break;
            }
        }
    }
}
