package userManagement.auth.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity login(String email, String password) {

        try {
            // Cria um objeto de autenticação com as credenciais fornecidas
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);
            System.out.println(authRequest);

            // Autentica o usuário usando o AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(authRequest);
            System.out.println(authentication);

            // Se a autenticação for bem-sucedida
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retorna uma resposta de sucesso
            return ResponseEntity.ok().build();

        } catch (Exception e) {

            System.err.println("Authentication failed: " + e.getMessage());
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
        }
    }
}
