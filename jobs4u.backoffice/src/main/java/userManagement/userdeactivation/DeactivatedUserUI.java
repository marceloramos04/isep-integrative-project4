package userManagement.userdeactivation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

@Component
public class DeactivatedUserUI implements Runnable {

    @Autowired
    private DeactivateUserController controller;

    @Override
    public void run() {

        try {

            System.out.println(" ==== LIST OF ACTIVATED USERS ====");

            System.out.println(controller.listActivatedUsers());

            Long id = Utils.readPositiveLongFromConsole("SELECT USER: ");

            boolean success = controller.deactivateUser(id);

            if (success) {

                System.out.println("USER DEACTIVATED WITH SUCCESS");

            } else {

                System.out.println("USER NOT DEACTIVATED");
            }

        } catch (Exception e) {

            System.err.println("ERROR: " + e.getMessage());
        }

    }
}
