package userManagement.listusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userManagement.domain.AppUser;

import java.util.List;

@Component
public class ListUsersUI implements Runnable {

    @Autowired
    private ListUsersController controller;

    @Override
    public void run() {

        try {

            System.out.println(" ====== USER LIST ====== ");

            List<AppUser> users = controller.listUsers();

            for (AppUser appUser : users) {
                System.out.println(appUser.toString());
            }
            System.out.println(" ==== END OF THE LIST ====");

        } catch (Exception e) {

            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
