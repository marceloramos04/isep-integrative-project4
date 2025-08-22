package menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.auth.login.LoginUI;
import userManagement.registeruser.RegisterUserUI;
import utils.Utils;

@Component
public class MainMenu {

    @Autowired
    private LoginUI loginUI;

    @Autowired
    private RegisterUserUI registerUserUI;

    public MainMenu() {
    }

    public void run() {

        System.out.println("========================================================");

        System.out.println("========== WELLCOME TO BACKOFFICE APPLICATION ==========");

        boolean running = true;

        while (running) {

            System.out.println(" \n ===== SELECT OPTION ===== ");

            System.out.println("0 - Exit");
            System.out.println("1 - Login");
            System.out.println("2 - Register User");

            int option = Utils.readIntegerFromConsole("Enter the number of the option you want to choose:");

            switch (option) {

                case 0:
                    running = false;
                    break;

                case 1:
                    loginUI.run();
                    break;

                case 2:
                    registerUserUI.run();
                    break;

                default:
                    System.err.println("\nINVALID OPTION");
            }
        }
    }
}
