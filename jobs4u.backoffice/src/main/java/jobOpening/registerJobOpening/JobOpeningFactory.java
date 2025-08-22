package jobOpening.registerJobOpening;

import customer.domain.Customer;
import jobOpening.domain.*;
import jobOpening.domain.jobOpeningAttributes.*;
import org.springframework.stereotype.Component;
import utils.PositiveInteger;
import utils.domain.address.Address;

@Component
public class JobOpeningFactory {

    public JobOpening createJobOpening(String jobTitle, int jobType, int workingMode, String street, String city, int buildingNumber, String zipCode, String companyName, int numberVacancies, String jobDescription, Customer customer) {
        JobTitle title = new JobTitle(jobTitle);

        JobType type = new JobType(jobType);

        CompanyName company = new CompanyName(companyName);

        JobDescription description = new JobDescription(jobDescription);

        JobWorkingMode mode = new JobWorkingMode(workingMode);

        Address address = new Address(street, buildingNumber, zipCode, city);

        PositiveInteger vacancies = new PositiveInteger(numberVacancies);

        return new JobOpening(title, type, mode, address, company, vacancies, description, customer);
    }

}
