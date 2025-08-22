package application.register_applications;

import candidate.RegisterCandidate.RegisterCandidateUI;
import eapli.framework.io.util.Console;
import jobOpening.domain.JobOpening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterApplicationsUI implements Runnable {

    @Autowired
    private RegisterApplicationController ctrl;

    @Autowired
    private RegisterCandidateUI registerCandidateUI;
    private JobOpening jobOffer;
    private String candidateEmail;
    private String filesDirectory;
    private final String SEPARATOR = "====================";

    @Override
    public void run() {
        //selectJobOffer();
        askCandidateEmail();
        /*if (!ctrl.isThereCandidate(candidateEmail)) {
            registerCandidate();
        }*/
        askFilesDirectory();
        conclude(askConfirmation());
    }

    /*private void selectJobOffer() {
        List<JobOpening> offers = ctrl.getActiveJobOffers();
        for (int i = 0; i < offers.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, offers.get(i).getJobTitle());
        }
        int option;
        do {
            option = Console.readInteger("Select job offer");
        } while (option < 1 || option > offers.size() + 1);
        jobOffer = offers.get(option - 1);
    }*/

    private void askCandidateEmail() {
        boolean validEmail;

        do {
            candidateEmail = Console.readLine("Introduza o email do cliente");

            validEmail = ctrl.checkEmailFormat(candidateEmail);
            if (!validEmail) {
                System.err.println("ERROR: Email em formato inválido\n");
            }

        } while (!validEmail);
    }

    private void registerCandidate() {
        registerCandidateUI.run();
    }

    private void askFilesDirectory() {
        filesDirectory = Console.readLine("Enter application files directory");
    }

    private boolean askConfirmation() {
        System.out.printf("%s SUMMARY OF CUSTOMER DATA %s\n\n", SEPARATOR, SEPARATOR);
        System.out.printf("Job offer= %s\n", jobOffer.getJobTitle());
        System.out.printf("Candidate email = %s\n", candidateEmail);
        System.out.printf("Application files = %s\n", filesDirectory);

        return Console.readBoolean("Pretende submeter o registro do cliente? (y/n)");
    }

    private void conclude(boolean confirmation) {
        if (confirmation) {
            /*if (ctrl.registerApplication(candidateEmail, jobOffer, filesDirectory)) {
                System.out.println("CANDIDATURA REGISTADA COM SUCESSO\n");
            } else {
                System.err.println("ERRO: NÃO FOI POSSÍVEL REGISTAR O CLIENTE\n");
            }*/
        }
    }
}
