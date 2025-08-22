package customer.persistence;

import customer.domain.Customer;
import customer.domain.CustomerCode;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public interface CustomerRep extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(EmailAddress email);
    boolean existsCustomerByCode(CustomerCode code);
/*    boolean deleteByEmail(String email);
    boolean deleteByCode(String code);*/

    @Transactional
    Customer findById(long id);

    Customer findByEmail(EmailAddress email);
}
