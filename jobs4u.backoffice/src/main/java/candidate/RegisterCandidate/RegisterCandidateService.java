package candidate.RegisterCandidate;

import candidate.CandidateRepository;
import candidate.domain.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import utils.PhoneNumber;


import java.util.Optional;

import org.slf4j.Logger;

@Service
public class RegisterCandidateService {

    //definir validações e restriçoes e avaliações condicionais

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    private boolean foundCandidate = false;
    private Optional<Candidate> candidate;
    private static final Logger logger = LoggerFactory.getLogger(RegisterCandidateService.class);

    @Transactional
    public Candidate registerCandidate(Name name, PhoneNumber phoneNumber, EmailAddress emailAddress, AppUser user) {

        checkIfCandidateDataIsValid(phoneNumber, emailAddress);

        if (!foundCandidate) {
            var newCandidate = new Candidate(name, phoneNumber, emailAddress);
            userRepository.save(user);
            candidateRepository.save(newCandidate);

            if (Optional.of
                    (userRepository.findByEmail(emailAddress.toString())).isPresent() &&
                    Optional.of(candidateRepository.findByEmail(emailAddress)).isPresent()) {
                logger.info("Transação concluída com sucesso: Candidato e Usuário foram salvos.");
                return newCandidate;
            }
        }
        logger.error("Erro na transação: Candidato ou Usuário não foram salvos.");
        throw new RuntimeException("Erro ao salvar Candidato e Usuário.");
      //  return null;
    }

    public boolean checkIfCandidateDataIsValid(PhoneNumber phoneNumber, EmailAddress emailAddress) {

        checkIfPhoneNumberIsRegistered(phoneNumber);
        checkIfUserIsRegistered(emailAddress);

        return foundCandidate;
    }

    private void checkIfUserIsRegistered(EmailAddress emailAddress) {

        candidate = Optional.ofNullable(candidateRepository.findByEmail(emailAddress));
        if (candidate.isPresent()) {
            foundCandidate = true;
        }
    }

    private void checkIfPhoneNumberIsRegistered(PhoneNumber phoneNumber) {
        candidate = Optional.ofNullable(candidateRepository.findByPhoneNumber(phoneNumber));
        if (candidate.isPresent()) {
            foundCandidate = true;
        }
    }


}
