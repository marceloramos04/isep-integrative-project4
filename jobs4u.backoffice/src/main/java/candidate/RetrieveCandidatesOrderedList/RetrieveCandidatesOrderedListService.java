package candidate.RetrieveCandidatesOrderedList;

import application.domain.Application;
import candidate.CandidateRepository;
import candidate.domain.Candidate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RetrieveCandidatesOrderedListService {

    private final CandidateRepository candidateRepository;
    HashMap<Candidate, Double> candidatesAndTheirInterviewPoints;

    public RetrieveCandidatesOrderedListService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    public HashMap<Candidate, Double> getCandidatesOrderedList(List<Application> applicationsReceived) {
        List<Application> applications = applicationsReceived;

        if (applications != null) {
            applications = getOnlyApplicationsWithInterview(applications);
            applications = sortApplicationsByInterviewPointsDescending(applications);
            getCandidates(applications);
            return candidatesAndTheirInterviewPoints;
        } else {
            return null;
        }
    }

    private List<Application> sortApplicationsByInterviewPointsDescending(List<Application> applications) {
        Collections.sort(applications, Comparator.comparingDouble(app -> app.getInterview().getInterviewResult()));
        Collections.reverse(applications);
        return applications;
    }


    private void getCandidates(List<Application> applications) {
        candidatesAndTheirInterviewPoints = new HashMap<>();
        for (Application application : applications) {
            candidatesAndTheirInterviewPoints.put(application.getCandidate(), application.getInterview().getInterviewResult());
        }
    }

    private List<Application> getOnlyApplicationsWithInterview(List<Application> applications) {
        List<Application> newList = new ArrayList<>();
        for (Application application : applications) {
            if (!application.getInterview().getStatus().retrieveDescription().equals("Not Interviewed")) {
                newList.add(application);
            }
        }
        return newList;
    }
}
