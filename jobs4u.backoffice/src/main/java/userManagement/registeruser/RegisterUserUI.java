package userManagement.registeruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.UserRole;
import utils.Utils;

import java.util.List;

@Component
public class RegisterUserUI implements Runnable {

    @Autowired
    private RegisterUserController controller;

    @Override
    public void run() {

        try {

            System.out.println(" ==== USER REGISTRATION ====");

            String name = Utils.readLineFromConsole("INSERT NAME: ");

            String email = Utils.readLineFromConsole("INSERT USER EMAIL: ");

            String password = Utils.readLineFromConsole("INSERT PASSWORD: ");

            List<UserRole> roles = controller.getRolesAsList();
            System.out.println(roles);
            int role = Utils.readPositiveIntegerFromConsole("SELECT A ROLE FOR THE USER");


            System.out.println(" === Review User Data ===");
            System.out.println("User Name: " + name);
            System.out.println("User Email: " + email);
            System.out.println("User Role: " + UserRole.getRoleById(role));
            System.out.println("User Password: " + password);


            int optionValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optionValidation == 1) {
                controller.registerUser(name, email, UserRole.getRoleById(role),password);

            } else {
                System.out.println("OPERATION CANCELED!");
            }

        } catch (Exception e) {

            System.out.println("ERROR " + e.getMessage());
        }

    }
}
