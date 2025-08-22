package eapli.jobs4u.app.backoffice;

import application.ApplicationRepository;
import application.domain.Application;
import application.domain.File;
import application.domain.Interview;
import candidate.CandidateRepository;
import candidate.domain.Candidate;
import customer.domain.Customer;
import customer.persistence.CustomerRep;
import eapli.framework.general.domain.model.EmailAddress;
import jobOpening.JobOpeningRepository;
import jobOpening.domain.JobOpening;
import jobOpening.domain.jobOpeningAttributes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.UserRepository;
import userManagement.domain.AppUser;
import userManagement.domain.Name;
import userManagement.domain.UserRole;
import userManagement.registeruser.UserFactory;
import utils.PhoneNumber;
import utils.PositiveInteger;
import utils.domain.address.Address;
import utils.plugins.PluginsRepo;
import utils.plugins.PluginImpl;
import jobOpening.domain.recruitmentPhases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

@Component
public class Bootstrap {

    @Autowired
    private UserFactory userFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PluginsRepo pluginsRepo;
    @Autowired
    private CustomerRep customerRep;
    @Autowired
    private JobOpeningRepository jobOpeningRepo;
    @Autowired
    private CandidateRepository candidateRepo;
    @Autowired
    private ApplicationRepository appRepo;

    private enum TodayPhase{
        Application,
        Screening,
        Interviews,
        Analysis,
        Result
    }

    private Properties thisProperties;

    public void run() {

        System.out.println("\nBootstrapping...\n");

        thisProperties=PropertiesLoader.loadProperties(Jobs4uBackoffice.PROPERTIES_FILE);

        createUserFromProperties("Admin", UserRole.ADMINISTRATOR, "admin.email", "admin.password");
        createUserFromProperties("Customer Manager", UserRole.CUSTOMER_MANAGER, "customer_manager.email", "customer_manager.password");
        createUserFromProperties("Operator", UserRole.OPERATOR, "operator.email", "operator.password");

        createPlugin("plugin.req_specs.description", "plugin.req_specs.executable", "plugin.req_specs.impl_class", "plugin.req_specs.config_file");
        createPlugin("plugin.interv_model.description", "plugin.interv_model.executable", "plugin.interv_model.impl_class", "plugin.interv_model.config_file");

        generateOtherDomainEntities();
    }

    private void createUserFromProperties(String username, UserRole userRole, String emailProperty, String passwordProperty){

        try{

            String email = thisProperties.getProperty(emailProperty);
            System.out.printf("%s = %s\n",  emailProperty, email);

            String password = thisProperties.getProperty(passwordProperty);
            System.out.printf("%s = %s\n",  passwordProperty, password);

            if (userRepository.existsByEmail(email)){
                AppUser user= userFactory.createUser(username, email, userRole, password);
                System.out.println("User already exists\n");

            } else {
                AppUser user= userFactory.createUser(username, email, userRole, password);
                userRepository.save(user);

                if (userRepository.existsByEmail(email)){
                    System.out.println("User created\n");
                } else System.out.println("User not created\n");
            }

        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void createPlugin(String descriptionKey, String executablePathKey, String implementationClassKey, String configFileKey){

        String description=thisProperties.getProperty(descriptionKey);
        System.out.println(descriptionKey + " = " + description);

        String executablePath=thisProperties.getProperty(executablePathKey);
        System.out.println(executablePathKey + " = " + executablePath);

        String implementationClass=thisProperties.getProperty(implementationClassKey);
        System.out.println(implementationClassKey + " = " + implementationClass);

        String configFile=thisProperties.getProperty(configFileKey);
        System.out.println(configFileKey + " = " + configFile);

        if (pluginsRepo.existsByExecutablePath(executablePath)){
            System.out.println("Updating " + description + "...");
        } else System.out.println("Creating " + description + "...");

        PluginImpl p=new PluginImpl(description, executablePath, implementationClass,  configFile);
        pluginsRepo.save(p);

        if (pluginsRepo.existsByExecutablePath(executablePath)){
            System.out.println(description + " successfully registered!\n");
        } else System.out.println(description + " not registered\n");
    }

    private void generateOtherDomainEntities(){

        String customerEmail="customer@test.com";
        Customer customer;

        if (!customerRep.existsCustomerByEmail(EmailAddress.valueOf(customerEmail))){
            customer=new Customer("customer", customerEmail, "c1", new Address("street", 1, "1111-111", "city"));
            customer=customerRep.save(customer);

        } else customer=customerRep.findByEmail(EmailAddress.valueOf(customerEmail));

        AppUser customerUser=userFactory.createUser(customer.getName().toString(), customer.getEmail().toString(), UserRole.CUSTOMER_MANAGER, "test");
        persistUser(customerUser);

        JobOpening jo1= buildAndSaveJopOpening("job opening in application phase", 1, 1, "street", "city", 1, "1111-111", "company", 1, "job description", customer);
        JobOpening jo2= buildAndSaveJopOpening("job opening in screening phase", 1, 1, "street", "city", 2, "1111-111", "company", 2, "job description", customer);
        JobOpening jo3= buildAndSaveJopOpening("job opening in interviews phase", 1, 1, "street", "city", 3, "1111-111", "company", 3, "job description", customer);
        JobOpening jo4= buildAndSaveJopOpening("job opening in analysis phase", 1, 1, "street", "city", 3, "1111-111", "company", 3, "job description", customer);
        JobOpening jo5= buildAndSaveJopOpening("job opening in results phase", 1, 1, "street", "city", 3, "1111-111", "company", 3, "job description", customer);

        setJobOpeningPhases(jo1, TodayPhase.Application);
        setJobOpeningPhases(jo2, TodayPhase.Screening);
        setJobOpeningPhases(jo3, TodayPhase.Interviews);
        setJobOpeningPhases(jo4, TodayPhase.Analysis);
        setJobOpeningPhases(jo5, TodayPhase.Result);

        Candidate cand1= buildAndSaveCandidate("candidate one", "123456789", "candidate1@test.com");
        Candidate cand2= buildAndSaveCandidate("candidate two", "123456789", "candidate2@test.com");
        Candidate cand3= buildAndSaveCandidate("candidate three", "123456789", "candidate3@test.com");

        AppUser candUser1=userFactory.createUser(cand1.getName().toString(), cand1.getEmail().toString(), UserRole.CANDIDATE, "test");
        AppUser candUser2=userFactory.createUser(cand2.getName().toString(), cand2.getEmail().toString(), UserRole.CANDIDATE, "test");
        AppUser candUser3=userFactory.createUser(cand3.getName().toString(), cand3.getEmail().toString(), UserRole.CANDIDATE, "test");

        persistUser(candUser1);
        persistUser(candUser2);
        persistUser(candUser3);

        ArrayList<File> files=new ArrayList<>();
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-big-file-1.txt"));
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-big-file-2.txt"));
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-candidate-data.txt"));
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-cv.txt"));
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-email.txt"));
        files.add(new File("scomp/applications-files-bot/Email-Bot-Output-Example/1-report-1.txt"));

        Application appJob1Cand1=buildAndSaveApplication(jo1, cand1, files, new Interview());
        Application appJob1Cand2=buildAndSaveApplication(jo1, cand2, files, new Interview());
        Application appJob1Cand3=buildAndSaveApplication(jo1, cand3, files, new Interview());

        Application appJob2Cand1=buildAndSaveApplication(jo2, cand1, files, new Interview());
        Application appJob2Cand2=buildAndSaveApplication(jo2, cand2, files, new Interview());
        Application appJob2Cand3=buildAndSaveApplication(jo2, cand3, files, new Interview());

        appJob2Cand1.setRequirementsFile(new File("docs/plugins/requirem-specs/valid-req-test-file.txt"));
        appJob2Cand2.setRequirementsFile(new File("docs/plugins/requirem-specs/valid-req-test-file.txt"));
        appJob2Cand3.setRequirementsFile(new File("docs/plugins/requirem-specs/valid-req-test-file-2.txt"));

        Application appJob3Cand1=buildAndSaveApplication(jo3, cand1, files, new Interview());
        Application appJob3Cand2=buildAndSaveApplication(jo3, cand2, files, new Interview());
        Application appJob3Cand3=buildAndSaveApplication(jo3, cand3, files, new Interview());

        Application appJob4Cand1=buildAndSaveApplication(jo4, cand1, files, new Interview());
        Application appJob4Cand2=buildAndSaveApplication(jo4, cand2, files, new Interview());
        Application appJob4Cand3=buildAndSaveApplication(jo4, cand3, files, new Interview());

        appJob4Cand1.uploadInterviewAnswers("docs/plugins/interv-model/valid-interv-test-file-3.txt");
        appJob4Cand2.uploadInterviewAnswers("docs/plugins/interv-model/valid-interv-test-file-2.txt");
        appJob4Cand3.uploadInterviewAnswers("docs/plugins/interv-model/valid-interv-test-file-3.txt");

        Application appJob5Cand1=buildAndSaveApplication(jo5, cand1, files, new Interview());
        Application appJob5Cand2=buildAndSaveApplication(jo5, cand2, files, new Interview());
        Application appJob5Cand3=buildAndSaveApplication(jo5, cand3, files, new Interview());

    }

    private JobOpening buildAndSaveJopOpening(String jobTitle, int jobType, int workingMode, String street, String city, int buildingNumber, String zipCode, String companyName, int numberVacancies, String jobDescription, Customer customer){
        JobTitle jt=new JobTitle(jobTitle);

        if (!jobOpeningRepo.existsByJobTitle(jt)){
            JobOpening jo= new JobOpening(jt,
                    new JobType(jobType),
                    new JobWorkingMode(workingMode),
                    new Address(street, buildingNumber, zipCode, city),
                    new CompanyName(companyName),
                    new PositiveInteger(numberVacancies),
                    new JobDescription(jobDescription),
                    customer);

             return jobOpeningRepo.save(jo);

        } else return jobOpeningRepo.findByJobTitle(jt);
    }

    private Candidate buildAndSaveCandidate(String name, String phoneNumber, String email){
        EmailAddress emailObj=EmailAddress.valueOf(email);

        if (!candidateRepo.existsByEmail(emailObj)){
            Candidate c= new Candidate(new Name(name),
                    new PhoneNumber(phoneNumber),
                    emailObj);

            return candidateRepo.save(c);

        } else return candidateRepo.findByEmail(emailObj);
    }

    private Application buildAndSaveApplication(JobOpening jo, Candidate cand, ArrayList<File> files, Interview interv){
        if (!appRepo.existsByJobOfferAndCandidate(jo, cand)){
            Application a=new Application(jo, interv, cand, files);
            return appRepo.save(a);

        } else return appRepo.findByJobOfferAndCandidate(jo, cand);
    }

    public void setJobOpeningPhases(JobOpening jo, TodayPhase todayPhase){

        int defaultPhasesDuration=3;
        int defaultIntervalBetweenPhases=1;
        int nextPhase=defaultPhasesDuration+defaultIntervalBetweenPhases;

        LocalDate referenceDate=LocalDate.now();

        switch (todayPhase){
            case Application:
                referenceDate=LocalDate.now();
                break;
            case Screening:
                referenceDate=LocalDate.now().minusDays(1 * nextPhase);
                break;
            case Interviews:
                referenceDate=LocalDate.now().minusDays(2 * nextPhase);
                break;
            case Analysis:
                referenceDate=LocalDate.now().minusDays(3 * nextPhase);
                break;
            case Result:
                referenceDate=LocalDate.now().minusDays(4 * nextPhase);
                break;
        }

        LocalDate appPhaseStart=referenceDate;
        LocalDate appPhaseEnd=appPhaseStart.plusDays(defaultPhasesDuration);
        ApplicationPhase appPhase=new ApplicationPhase(appPhaseStart, appPhaseEnd);

        LocalDate srcPhaseStart=appPhaseEnd.plusDays(defaultIntervalBetweenPhases);
        LocalDate srcPhaseEnd=srcPhaseStart.plusDays(defaultPhasesDuration);
        ScreeningPhase scrPhase=new ScreeningPhase(srcPhaseStart, srcPhaseEnd);

        LocalDate intPhaseStart=srcPhaseEnd.plusDays(defaultIntervalBetweenPhases);
        LocalDate intPhaseEnd=intPhaseStart.plusDays(defaultPhasesDuration);
        InterviewsPhase intPhase=new InterviewsPhase(intPhaseStart, intPhaseEnd);

        LocalDate anaPhaseStart=intPhaseEnd.plusDays(defaultIntervalBetweenPhases);
        LocalDate anaPhaseEnd=anaPhaseStart.plusDays(defaultPhasesDuration);
        AnalysisPhase anaPhase=new AnalysisPhase(anaPhaseStart, anaPhaseEnd);

        LocalDate resPhaseStart=anaPhaseEnd.plusDays(defaultIntervalBetweenPhases);
        LocalDate resPhaseEnd=resPhaseStart.plusDays(defaultPhasesDuration);
        ResultPhase resPhase=new ResultPhase(resPhaseStart, resPhaseEnd);

        RecruitmentProcess recruitmentProcess=new RecruitmentProcess(appPhase, scrPhase, intPhase, anaPhase, resPhase);
        jo.setupPhases(recruitmentProcess);
        jobOpeningRepo.save(jo);
    }

    private void persistUser(AppUser user){
        if (!userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
        }
    }
}
