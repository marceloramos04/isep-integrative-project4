package candidate.RegisterCandidate;

import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebResourcesRuntimeHints;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import userManagement.domain.Name;
import utils.PhoneNumber;
import utils.Utils;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class RegisterCandidateUI implements Runnable {

    @Autowired
    private CandidateFactory candidateFactory;
    @Autowired
    private RegisterCandidateController registerCandidateController;
    private boolean invalid = false;
    private String candidateFirstName;
    private String candidateLastName;
    private String candidatephoneNumber;
    private String candidateemail;
    private Name name;
    private eapli.framework.infrastructure.authz.domain.model.Name name2;
    private PhoneNumber phoneNumber;
    private EmailAddress email;
    private String password;
    private Optional<Candidate> candidate;

    @Override
    public void run() {

        requestCandidateData();

        try {
            name2 = candidateFactory.retrieveName(candidateFirstName, candidateLastName);
            phoneNumber = candidateFactory.retrievePhoneNumber(candidatephoneNumber);
            email = candidateFactory.retrieveEmailAddress(candidateemail);
            System.out.println("got here");
        } catch (IllegalArgumentException i) {
        }

        do {
            if (invalid) System.out.println("Sorry but the password you entered is invalid.\nPlease try again.");
            invalid = false;
            password = Utils.readLineFromConsole("Insert the password: ");
            if (password.length() < 4 || password == null) {
                invalid=true;
            }else if(password.trim().isEmpty()){
                invalid=true;
            }
            }
            while (invalid) ;

            do {
                if (invalid) System.out.println("Sorry but the option you entered is invalid.\nPlease try again.");
                int answer = Utils.readIntegerFromConsole("New Candidate:\n" + "Candidate Name:" + name2.toString() + "\nCandidate Phone Number:" + phoneNumber + "\nCandidate Email Addres:" + email + "\n\n Would you like to save this New Candidate Profile?\n1-Yes\n2-No");

                String fullname = name2.firstName() + " " + name2.lastName();

                name = new Name(fullname);

                if (answer == 1) {
                    candidate = registerCandidateController.registerCandidate(name, phoneNumber, email, password);
                    if (candidate.isPresent()) {
                        System.out.println("New Candidate Profile successfuly saved!!");
                    } else {
                        System.out.println("Something went wrong and the system wasnt able to register the candidate" + "\nPlease try again later :(\n");
                    }
                    invalid = false;
                } else if (answer == 2) {
                    invalid = false;
                    System.out.println("Registration Cancelled");
                } else {
                    invalid = true;
                }
            } while (invalid);
        }


        public void requestCandidateData () {

            System.out.println("Registering a new Candidate\n");
            requestCandidateName(1);
            requestCandidateName(2);


            do {
                invalid = false;
                candidatephoneNumber = Utils.readLineFromConsole("Insert the candidate´s phone number: ");
                if (candidatephoneNumber.length() != 9) {
                    System.out.println("Sorry but, the phone number must have nine digits.\nPlease try again\n");
                    invalid = true;
                }

            } while (invalid);

            do {
                invalid = false;
                candidateemail = Utils.readLineFromConsole("Insert the candidate´s email: ");
                if (candidateemail == null || !Pattern.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b", candidateemail)) {
                    System.out.println("Sorry but the email you entered is invalid. Please try again.");
                    invalid = true;
                }
            } while (invalid);
        }


        private void requestCandidateName ( int x){
            Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
            do {
                if (x == 1) {
                    do {
                        invalid = false;
                        candidateFirstName = Utils.readLineFromConsole("Insert the candidate´s first name: \nNote: The name cannot contain numbers or any special characters, and must consist only of letters or spaces between words.");
                        if (candidateFirstName == null || candidateFirstName.trim().isEmpty() || !pattern.matcher(candidateFirstName).matches()) {
                            System.out.println("Sorry, it seems like the name you entered is invalid.\nPlease try again.");
                            invalid = true;
                        }
                    } while (invalid);

                } else if (x == 2) {
                    do {
                        invalid = false;
                        candidateLastName = Utils.readLineFromConsole("\nInsert the candidate´s last name: \nNote: The name cannot contain numbers or any special characters, and must consist only of letters or spaces between words.");
                        if (candidateLastName == null || candidateLastName.trim().isEmpty() || !pattern.matcher(candidateLastName).matches()) {
                            System.out.println("Sorry, it seems like the name you entered is invalid.\nPlease try again.");
                            invalid = true;
                        }
                    } while (invalid);

                } else {
                    System.out.println("The option you entered is not valid.\nTry again.\n");
                    invalid = true;
                }
            } while (invalid);

        }

    }
