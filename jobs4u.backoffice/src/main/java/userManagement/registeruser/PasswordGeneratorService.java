package userManagement.registeruser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorService {

    public static String hashPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
    }

}