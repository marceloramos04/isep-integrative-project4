package customer.use_cases;

import customer.domain.Customer;
import customer.domain.CustomerCode;
import userManagement.UserRepository;
import userManagement.domain.UserRole;
import userManagement.registeruser.PasswordGeneratorService;
import userManagement.registeruser.UserFactory;
import utils.domain.address.Address;
import customer.persistence.CustomerRep;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerManagementService {

    @Autowired
    private CustomerRep repo;

    @Autowired
    private UserFactory userFactory;
    @Autowired
    private UserRepository userRepository;

    public boolean isCustomerEmailUnique(String email) {
        return !repo.existsCustomerByEmail(EmailAddress.valueOf(email));
    }

    public boolean isCustomerCodeUnique(String code) {
        return !repo.existsCustomerByCode(new CustomerCode(code));
    }

    @Transactional
    public boolean registerCustomer(String name, String email, String customerCode,
                                    String street, int buildingNumber, String zipcode, String city,
                                    String password) {

        try {

            Address address = new Address(street, buildingNumber, zipcode, city);
            repo.save(new Customer(name, email, customerCode, address));
            userRepository.save(userFactory.createUser(name, email, UserRole.CUSTOMER, password));
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public boolean deleteCustomerByEmail(String email){
        return repo.deleteByEmail(email);
    }

    public boolean deleteCustomerByCode(String code){
        return repo.deleteByCode(code);
    }*/
}
