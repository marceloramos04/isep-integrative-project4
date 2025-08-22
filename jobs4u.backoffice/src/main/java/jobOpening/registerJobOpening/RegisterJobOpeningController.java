package jobOpening.registerJobOpening;


import customer.domain.Customer;
import customer.persistence.CustomerRep;
import jobOpening.domain.JobOpening;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.jobOpeningAttributes.JobReference;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import utils.PositiveInteger;
import utils.Title;
import utils.WiderDescription;

import java.util.List;

@Controller
public class RegisterJobOpeningController {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private JobOpeningFactory jobOpeningFactory;

    @Autowired
    private CustomerRep customerRep;

    public void registerJobOpening(String jobTitle, int jobType, int workingMode, String street, String city, int buildingNumber, String zipCode, String CompanyName, int numberVacancies, String jobDescription, Customer customer) {
        JobOpening jobOpening = jobOpeningFactory.createJobOpening(jobTitle, jobType, workingMode, street, city, buildingNumber, zipCode, CompanyName, numberVacancies, jobDescription,customer );
        jobOpeningRepository.save(jobOpening);
    }

    public void registerJobOpening(JobOpening jobOpening) {
        jobOpeningRepository.save(jobOpening);
    }

    public List<Customer> getCostumers() {
        return customerRep.findAll();
    }
}
