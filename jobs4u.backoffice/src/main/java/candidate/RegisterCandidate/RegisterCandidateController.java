package candidate.RegisterCandidate;

import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;
import userManagement.registeruser.UserFactory;
import utils.PhoneNumber;

import java.util.Optional;

@Component
public
class RegisterCandidateController {

    private final UserRole role = UserRole.CANDIDATE;
    @Autowired
    private RegisterCandidateService registerCandidateService;
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private UserRepository userRepository;
    private AppUser user;
    private Optional<Candidate> candidate;

    public Optional<Candidate> registerCandidate(Name name, PhoneNumber phoneNumber, EmailAddress emailAddress, String password) {

        user = userFactory.createUser(name.toString(), emailAddress.toString(), role, password);
        candidate = Optional.of(registerCandidateService.registerCandidate(name, phoneNumber, emailAddress, user));

        if (candidate.isPresent()) {
            return candidate;
        }


        return null;
    }
}