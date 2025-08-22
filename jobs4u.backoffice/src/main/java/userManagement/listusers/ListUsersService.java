package userManagement.listusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userManagement.UserRepository;
import userManagement.domain.AppUser;

import java.util.List;

@Service
public class ListUsersService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> listUsers() {
        return userRepository.findAll();
    }
}
