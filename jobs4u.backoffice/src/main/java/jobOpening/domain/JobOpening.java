package jobOpening.domain;

import customer.domain.Customer;
import jakarta.persistence.*;
import jobOpening.domain.jobOpeningAttributes.*;
import lombok.Getter;
import utils.PositiveInteger;
import utils.domain.address.Address;
import utils.domain.ranking.Ranking;

import java.util.*;

@Getter

@Entity
public class JobOpening {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Column(name = "Reference")
    private JobReference reference;

    @Getter
    @ManyToOne()
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @Getter
    @Column(name = "jobTitle", nullable = false)
    private JobTitle jobTitle;

    @Column(name = "jobType", nullable = false)
    private JobType jobType;

    @Column(name = "address", nullable = false)
    private Address address;

    @Column(name = "companyName", nullable = false)
    private CompanyName companyName;

    @Getter
    @Column(name = "numberVacancies", nullable = false)
    private PositiveInteger numberVacancies;

    @Column(name = "jobDescription", nullable = false)
    private JobDescription jobDescription;

    @Column(name = "workingMode", nullable = false)
    private JobWorkingMode workingMode;

    @Embedded
    @Column(name = "recruitmentProcess")
    private RecruitmentProcess recruitmentProcess;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "job_opening_rankings", joinColumns = @JoinColumn(name = "job_opening_id"))
    private List<Ranking> rankings = new ArrayList<>();



    protected JobOpening() {
        // ORM
    }

    /** Constructor for JobOpening
     */
    public JobOpening(JobTitle jobTitle, JobType jobType, JobWorkingMode workingMode, Address address, CompanyName companyName, PositiveInteger numberVacancies, JobDescription jobDescription, Customer customer) {
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.workingMode = workingMode;
        this.address = address;
        this.companyName = companyName;
        this.numberVacancies = numberVacancies;
        this.jobDescription = jobDescription;
        this.customer = customer;
        this.reference = new JobReference(buildReference(customer));
    }

    private String buildReference(Customer customer) {
        String reference = customer.getCode().getCode() + customer.getJobOpeningCounter();
        return reference;
    }

    /**
     * Set up the recruitment process phases
     */
    public void setupPhases(RecruitmentProcess recruitmentProcess) {
        if (recruitmentProcess == null) {
            throw new IllegalArgumentException("Recruitment process cannot be null");
        }
        this.recruitmentProcess = recruitmentProcess;
    }

    public void addRanking(Ranking ranking) {
        if (ranking == null) {
            throw new IllegalArgumentException("Ranking cannot be null");
        }
        if(rankings.contains(ranking)){
            throw new IllegalArgumentException("Ranking already exists for this candidate in this job opening");
        }
        this.rankings.add(ranking);
        this.rankings.sort(Comparator.comparing(Ranking::getRank, (r1, r2) -> {
            if (r1.equals("rank not recorded")) return 1;
            if (r2.equals("rank not recorded")) return -1;
            return r1.compareTo(r2);
        }));
    }

    public String activePhase() {
        if (recruitmentProcess == null) return null;
        return recruitmentProcess.getActivePhase();
    }

    public boolean isActive() {
        return activePhase()!=null;
    }

    public String closeActivePhase(){
        return recruitmentProcess.closeActivePhase();
    }

    //editing the job opening

    public void editJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void editJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void editWorkingMode(JobWorkingMode workingMode) {
        this.workingMode = workingMode;
    }

    public void editAddress(Address address) {
        this.address = address;
    }

    public void editCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public void editNumberVacancies(PositiveInteger numberVacancies) {
        this.numberVacancies = numberVacancies;
    }

    public void editJobDescription(JobDescription jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void editRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
        this.recruitmentProcess = recruitmentProcess;
    }

    public void addReference(JobReference reference) {
        this.reference = reference;
    }


    /** To String for JobOpening
     * @return String with the JobOpening information
     */
    @Override
    public String toString() {
        StringBuilder rankingsStr = new StringBuilder();
        for (Ranking ranking : rankings) {
            rankingsStr.append(ranking.toString()).append("\n");
        }

        return "JobOpening :\n" +
                " \n| Job title : " + jobTitle +
                " \n| Description :" + jobDescription +
                " \n| Type of job : " + jobType +
                " \n| Working mode : " + workingMode +
                " \n| Company Name : " + companyName +
                " \n| Address : " + address +
                " \n| Available vacancies : " + numberVacancies +
                " \n| Rankings : \n" + rankingsStr;
    }

}
