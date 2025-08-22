package candidate.RegisterCandidate;

import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.PhoneNumber;

@Component
public class CandidateFactory {
    private userManagement.domain.Name name2;

    public CandidateFactory() {
    }

    public eapli.framework.infrastructure.authz.domain.model.Name retrieveName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return null;
        }
        return Name.valueOf(firstName, lastName);
    }

    public PhoneNumber retrievePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return new PhoneNumber(phoneNumber);
    }

    public eapli.framework.general.domain.model.EmailAddress retrieveEmailAddress(String emailAddress) {
        if (emailAddress == null) {
            return null;
        }
        return EmailAddress.valueOf(emailAddress);
    }

    public Candidate createCandidate(String firstName, String lastName, String phoneNumber, String emailAddress) {
        String fullName = firstName + " " + lastName;
        return new Candidate(new userManagement.domain.Name(fullName), retrievePhoneNumber(phoneNumber), retrieveEmailAddress(emailAddress));
    }


}
