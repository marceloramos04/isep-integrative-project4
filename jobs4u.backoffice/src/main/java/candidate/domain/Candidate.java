package candidate.domain;

import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;
import lombok.Getter;
import userManagement.domain.Name;
import utils.PhoneNumber;



@Entity
public class Candidate {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Column(name = "Name", nullable = false)
    private Name name;

    @Getter
    @Column(name = "Phone_Number", nullable = false, length = 9)
    private PhoneNumber phoneNumber;

    @Getter
    @Column(name = "Email", nullable = false)
    private EmailAddress email;

    protected Candidate() {
        // ORM
    }

    public Candidate(Name name, PhoneNumber phoneNumber, EmailAddress email) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if (phoneNumber == null) {
            throw new NullPointerException("PhoneNumber cannot be null");
        }
        if (email == null) {
            throw new NullPointerException("Email cannot be null");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-20s %n", name, phoneNumber, email);
    }

}
