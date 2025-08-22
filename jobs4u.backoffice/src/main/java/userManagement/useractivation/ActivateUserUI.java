package userManagement.useractivation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

@Component
public class ActivateUserUI implements Runnable {

    @Autowired
    private ActivateUserController controller;

    @Override
    public void run() {

        try {

            System.out.println(" ==== LIST OF DEACTIVATED USERS ====");

            System.out.println(controller.listDeactivatedUsers());

            long id = Utils.readPositiveLongFromConsole("SELECT USER: ");

            boolean success = controller.activateUser(id);

            if (success) {

                System.out.println("USER ACTIVATED WITH SUCCESS");

            } else {

                System.out.println("USER NOT ACTIVATED");
            }

        } catch (Exception e) {

            System.err.println("ERROR: " + e.getMessage());
        }

    }
}
