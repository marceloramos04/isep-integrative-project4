package customer.domain;

import lombok.Getter;
import utils.domain.address.Address;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;
import utils.Title;


@Entity
public class Customer {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(nullable = false)
    private Title name;

    @Getter
    @Column(nullable = false, unique = true)
    private EmailAddress email;

    @Getter
    @Column(nullable = false, unique = true)
    private CustomerCode code;

    @Column(nullable = false)
    private Address address;

    public static int jobOpeningCounter = 0;

    protected Customer() {
        // ORM
    }

    public Customer(String name, String email, String code, Address address) {
        this.name = new Title(name);
        this.email = EmailAddress.valueOf(email);
        this.code = new CustomerCode(code);
        this.address = address;
    }

    public int getJobOpeningCounter() {
        jobOpeningCounter++;
        return (jobOpeningCounter);
    }

    @Override
    public String toString() {
        return String.format("Name = %-30s | Email = %-30s | Customer Code = %-30s | Address = %-50s", name, email, code, address.toString());
    }
}
