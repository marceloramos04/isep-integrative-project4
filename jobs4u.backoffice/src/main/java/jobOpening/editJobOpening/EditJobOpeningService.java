package jobOpening.editJobOpening;

import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.PositiveInteger;
import utils.domain.address.Address;

@Service
public class EditJobOpeningService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public boolean editJobTitle(String title, long jobOpeningId) {
        if(JobTitle.isValid(title)) {
            JobTitle jobTitle = new JobTitle(title);
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editJobTitle(jobTitle);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public boolean editJobType(String type, long jobOpeningId) {
        if(JobType.isValid(Integer.parseInt(type))) {
            JobType jobType = new JobType(Integer.parseInt(type));
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editJobType(jobType);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public boolean editWorkingMode(String workingMode, long jobOpeningId) {
        if(JobWorkingMode.isValid(Integer.parseInt(workingMode))) {
            JobWorkingMode jobWorkingMode = new JobWorkingMode(Integer.parseInt(workingMode));
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editWorkingMode(jobWorkingMode);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public boolean editCompanyName(String name, long jobOpeningId) {
        if(CompanyName.isValid(name)) {
            CompanyName companyName = new CompanyName(name);
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editCompanyName(companyName);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public boolean editNumberVacancies(int number, long jobOpeningId) {
        if (PositiveInteger.isValid(number)) {
            PositiveInteger positiveInteger = new PositiveInteger(number);
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editNumberVacancies(positiveInteger);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public boolean editJobDescription(String description, long jobOpeningId) {
        if (JobDescription.isValid(description)) {
            JobDescription jobDescription = new JobDescription(description);
            JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId);
            jobOpening.editJobDescription(jobDescription);
            jobOpeningRepository.save(jobOpening);
            return true;
        }
        return false;
    }

    public void editAddress(String city, String street, String zipcode, int buildingNumber, long id) {
        Address address = new Address(street, buildingNumber, zipcode, city);
        JobOpening jobOpening = jobOpeningRepository.findById(id);
        jobOpening.editAddress(address);
        jobOpeningRepository.save(jobOpening);
    }
}
