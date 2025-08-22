package customer.use_cases.register_customer;

import userManagement.domain.UserRole;
import userManagement.registeruser.PasswordGeneratorService;
import userManagement.registeruser.UserFactory;
import utils.domain.address.ZipCode;
import customer.domain.CustomerCode;
import eapli.framework.application.UseCaseController;
import eapli.framework.strings.util.StringPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import customer.use_cases.CustomerManagementService;

//@UseCaseController
@Component
public class RegisterCustomerCtrl {

    @Autowired
    private CustomerManagementService customerManagement;
    //private CustomerManagementService customerManagement=new CustomerManagementService();

    public boolean checkEmailFormat(String email) {
        return StringPredicates.isEmail(email);
    }

    public boolean isEmailUnique(String email) {
        return customerManagement.isCustomerEmailUnique(email);
    }

    public boolean checkCustomerCodeFormat(String code) {
        return CustomerCode.checkCustomerCodeFormat(code);
    }

    public boolean isCustomerCodeUnique(String code) {
        return customerManagement.isCustomerCodeUnique(code);
    }

    public boolean checkZipCodeFormat(String zipCode) {
        return ZipCode.checkZipCodeFormat(zipCode);
    }

    public boolean registerCustomer(String name, String email, String customerCode,
                                    String street, int buildingNum, String zipcode, String city,
                                    String password) {

        return customerManagement.registerCustomer(name, email, customerCode, street, buildingNum, zipcode, city, password);

    }
}
