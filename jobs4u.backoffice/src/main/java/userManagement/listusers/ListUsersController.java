package userManagement.listusers;

import userManagement.domain.AppUser;
import userManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListUsersController {

    @Autowired
    private ListUsersService listUsersService;

    public List<AppUser> listUsers() {
        return listUsersService.listUsers();
    }
}
