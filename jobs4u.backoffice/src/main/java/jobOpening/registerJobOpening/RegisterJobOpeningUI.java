package jobOpening.registerJobOpening;


import application.register_applications.RegisterApplicationController;
import customer.domain.Customer;
import eapli.framework.general.domain.model.Text;
import jobOpening.domain.jobOpeningAttributes.CompanyName;
import jobOpening.domain.jobOpeningAttributes.JobDescription;
import jobOpening.domain.jobOpeningAttributes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.PositiveInteger;
import utils.Utils;
import utils.domain.address.ZipCode;


@Component
public class RegisterJobOpeningUI implements Runnable {

    String jobTitle, street, city, zipCode, companyName, jobDescription;
    int jobType, numberVacancies, workingMode, buildingNumber;
    Customer customer;

    @Autowired
    private RegisterJobOpeningController registerJobOpeningController;
    @Autowired
    private RegisterApplicationController registerApplicationController;

    @Override
    public void run() {
        System.out.println("Register Job Opening UI\n");

        getJobOpeningData();

        registerJobOpeningController.registerJobOpening(jobTitle, jobType, workingMode, street, city, buildingNumber, zipCode, companyName, numberVacancies, jobDescription, customer);

        System.out.println("Job opening registered successfully :\n" +
                "Job title : " + jobTitle + "\n" +
                "Job type : " + jobType + "\n" +
                "Working mode : " + workingMode + "\n" +
                "Address : " + street + ", " + buildingNumber + ", " + zipCode + ", " + city + "\n" +
                "Company name : " + companyName + "\n" +
                "Number of vacancies : " + numberVacancies + "\n" +
                "Job description : " + jobDescription + "\n")

        ;

    }

    private void getJobOpeningData() {

        //get job title

        while (true) {
            String jobTitle = Utils.readLineFromConsole("Enter job title : ");
            if (JobTitle.isValid(jobTitle)) {
                this.jobTitle = jobTitle;
                break;
            }
            System.out.println("Invalid job title. Please try again.");
        }

        //get job type
        while (true) {
            System.out.println("Select job type :");
            System.out.println("1 - Full time");
            System.out.println("2 - Part time");
            int jobType = Utils.readIntegerFromConsole("SelectOption : ");
            if (jobType==1 || jobType==2) {
                this.jobType = jobType;
                break;
            }
            System.out.println("Invalid job type. Please try again.");
        }

        //get working mode
        while (true) {
            System.out.println("Select working mode :");
            System.out.println("1 - Remote");
            System.out.println("2 - On site");
            System.out.println("3 - Hybrid");
            int workingMode = Utils.readIntegerFromConsole("SelectOption : ");
            if (workingMode==1 || workingMode==2 || workingMode==3) {
                this.workingMode = workingMode;
                break;
            }
            System.out.println("Invalid working mode. Please try again.");
        }

        //get city, street, building number and zip code
        while (true) {
            String city = Utils.readLineFromConsole("Enter city : ");
            if (Text.valueOf(city).wordCount()> 0) {
                this.city = city;
                break;
            }
            System.out.println("Invalid address. Please try again.");
        }
        while (true) {
            String street = Utils.readLineFromConsole("Enter street : ");
            if (Text.valueOf(street).wordCount()> 0) {
                this.street = street;
                break;
            }
            System.out.println("Invalid address. Please try again.");
        }
        while (true) {
            int buildingNumber = Utils.readIntegerFromConsole("Enter building number : ");
            if (PositiveInteger.isValid(buildingNumber)) {
                this.buildingNumber = buildingNumber;
                break;
            }
            System.out.println("Invalid building number. Please try again.");
        }
        while (true) {
            String zipCode = Utils.readLineFromConsole("Enter zip code (1234-567): ");
            if (ZipCode.checkZipCodeFormat(zipCode)) {
                this.zipCode = zipCode;
                break;
            }
            System.out.println("Invalid address. Please try again.");
        }

        //get company name
        while (true) {
            String companyName = Utils.readLineFromConsole("Enter company name : ");
            if (CompanyName.isValid(companyName)) {
                this.companyName = companyName;
                break;
            }
            System.out.println("Invalid company name. Please try again.");
        }

        //get customer
        while (true) {
            int index = Utils.showAndSelectIndex(registerJobOpeningController.getCostumers(), "Select costumer : ");
            if (registerJobOpeningController.getCostumers().get(index) != null) {
                this.customer = registerJobOpeningController.getCostumers().get(index);
                break;
            }
            System.out.println("Invalid selection. Please try again.");
        }

        //get number of vacancies
        while (true) {
            int numberVacancies = Utils.readIntegerFromConsole("Enter number of vacancies : ");
            if (PositiveInteger.isValid(numberVacancies)) {
                this.numberVacancies = numberVacancies;
                break;
            }
            System.out.println("Invalid number of vacancies. Please try again.");
        }

        //get job description
        while (true) {
            String jobDescription = Utils.readLineFromConsole("Enter job description : ");
            if (JobDescription.isValid(jobDescription)) {
                this.jobDescription = jobDescription;
                break;
            }
            System.out.println("Invalid job description. Please try again.");
        }

    }



}
