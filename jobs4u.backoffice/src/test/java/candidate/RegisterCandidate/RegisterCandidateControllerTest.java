/*
package candidate.RegisterCandidate;


import candidate.domain.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class RegisterCandidateControllerTest {

    @Mock
    private RegisterCandidateService registerCandidateService;

    @InjectMocks
    private RegisterCandidateController registerCandidateController;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void listAllCandidatesControllerTest() {
        RegisterCandidateDto candidateDto = new RegisterCandidateDto("Dephane", 999888777, "test2@email.com","123");
        Candidate candidate = new Candidate("Dephane", 999888777, "test2@email.com");

        RegisterCandidateDto candidateDto2 = new RegisterCandidateDto("Sara", 999889777, "test3@email.com","123");
        Candidate candidate2 = new Candidate("Sara", 999889777, "test3@email.com");

        RegisterCandidateDto candidateDto3 = new RegisterCandidateDto("Joao", 999880777, "test42@email.com","123");
        Candidate candidate3 = new Candidate("Joao", 999880777, "test42@email.com");

        List<Candidate> candidatesExpectedList = new ArrayList<>();
        candidatesExpectedList.add(candidate);
        candidatesExpectedList.add(candidate2);
        candidatesExpectedList.add(candidate3);


        when(registerCandidateService.save(any())).thenReturn(candidate);
        Candidate savedCandidate = registerCandidateController.saveCandidate(candidateDto);

        when(registerCandidateService.save(any())).thenReturn(candidate2);
        Candidate savedCandidate2 = registerCandidateController.saveCandidate(candidateDto2);

        when(registerCandidateService.save(any())).thenReturn(candidate3);
        Candidate savedCandidate3 = registerCandidateController.saveCandidate(candidateDto3);


        assertEquals(candidate, savedCandidate);
        assertEquals(candidate2, savedCandidate2);
        assertEquals(candidate3, savedCandidate3);

        //verify(registerCandidateService, times(1)).save(candidate);
        //verify(registerCandidateService, times(1)).save(candidate2);
        //verify(registerCandidateService, times(1)).save(candidate3);


    }
}
*/
