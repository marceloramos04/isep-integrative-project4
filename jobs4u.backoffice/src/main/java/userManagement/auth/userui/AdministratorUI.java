package userManagement.auth.userui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.listusers.ListUsersUI;
import userManagement.registeruser.RegisterUserUI;
import userManagement.useractivation.ActivateUserUI;
import userManagement.userdeactivation.DeactivatedUserUI;
import utils.Utils;

@Component
public class AdministratorUI implements Runnable {

    @Autowired
    private RegisterUserUI registerUserUI;

    @Autowired
    private ListUsersUI listUsersUI;

    @Autowired
    private ActivateUserUI activateUserUI;

    @Autowired
    private DeactivatedUserUI deactivatedUserUI;

    @Override
    public void run() {

        boolean exit = false;

        while (!exit) {
            System.out.println("====== ADMINISTRATOR MENU ====== ");

            System.out.println("0 - Exit");
            System.out.println("1 - Register User");
            System.out.println("2 - Activate User");
            System.out.println("3 - Deactivate User");
            System.out.println("4 - List Users");

            int option = Utils.readPositiveIntegerFromConsole("Enter the number of the option you want to choose:");

            switch (option) {

                case 0:
                    exit = true;
                    break;

                case 1:
                    registerUserUI.run();
                    break;

                case 2:
                    activateUserUI.run();
                    break;

                case 3:
                    deactivatedUserUI.run();
                    break;

                case 4:
                    listUsersUI.run();
                    break;

                default:
                    System.err.println("INVALID OPTION");
            }
        }
    }
}