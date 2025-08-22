package userManagement.auth.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import userManagement.auth.userui.AdministratorUI;
import userManagement.auth.userui.CustomerManagerUI;
import userManagement.auth.userui.OperatorUI;
import userManagement.domain.AppUser;
import userManagement.domain.UserRole;
import utils.Utils;

import java.util.Collection;

@Component
public class LoginUI implements Runnable {

    @Autowired
    private AdministratorUI administratorUI;

    @Autowired
    private CustomerManagerUI customerManagerUI;

    @Autowired
    private OperatorUI operatorUI;

    @Autowired
    private AuthenticationController authenticationController;

    @Override
    public void run() {

        try {
            System.out.println("==== LOGIN UI ====");

            String email = Utils.readLineFromConsole("INSERT EMAIL: ");
            String password = Utils.readLineFromConsole("INSERT PASSWORD: ");

            // Debugging: Print entered email and password
            System.out.println("Entered Email: " + email);
            System.out.println("Entered Password: " + password);

            ResponseEntity loginResponse = authenticationController.login(email, password);

            // Debugging: Print login response status code
            System.out.println("Login Response Status Code: " + loginResponse.getStatusCode());

            if (loginResponse.getStatusCode().is2xxSuccessful()) {
                System.out.println("Login Successful");

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (authentication != null && authentication.isAuthenticated()) {

                    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

                    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

                    AppUser appUser = (AppUser) userDetails;

                    for (GrantedAuthority authority : authorities) {

                        String role = authority.getAuthority();
                        System.out.println(role);

                        UserRole roleName = appUser.getRole();

                        boolean check = true;

                        while (check) {

                            if (roleName.equals(UserRole.ADMINISTRATOR)) {
                                administratorUI.run();
                            }

                            if (roleName.equals(UserRole.CUSTOMER_MANAGER)) {
                                customerManagerUI.run();
                            }

                            if (roleName.equals(UserRole.OPERATOR)) {
                                operatorUI.run();
                            }

                            if ((roleName.equals(UserRole.CANDIDATE))) {
                                System.out.println("You are a candidate");
                                //candidateUI.run();
                                break;
                            }

                            if (roleName.equals(UserRole.CUSTOMER)) {

                                System.out.println("Customer role is not allowed to access the system.");
                                check = false;

                            } else {
                                System.out.println("Invalid Role");
                                check = false;
                            }
                        }
                    }

                } else {
                    System.out.println("Authentication failed or user is not authenticated.");
                }

            } else {
                System.out.println("Login failed: " + loginResponse.getStatusCode());
            }

        } catch (NullPointerException npe) {

            System.err.println(npe.getMessage());

        } catch (Exception e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

