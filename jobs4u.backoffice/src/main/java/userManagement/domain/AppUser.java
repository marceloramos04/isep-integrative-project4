package userManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Name name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean enabled;

    @Getter
    @Column(nullable = false)
    private UserRole role;

    protected AppUser() {
        //ORM
    }

    public AppUser(Name name, String email, String password, UserRole role) {
        this.name = name;
        this.email = setEmail(email);
        this.password = setPassword(password);
        this.role = role;
        this.enabled = true;
    }

    private String setEmail(String email) {

        if (email == null) {

            throw new NullPointerException("User email can't be null");

        } else if (email.trim().isEmpty()) {

            throw new IllegalArgumentException("User email must be filled");

        } else if (!email.contains("@")) {

            throw new IllegalArgumentException("Email must contain @");
        }
        return email;
    }

    private String setPassword(String password) {

        if (password == null) {

            throw new NullPointerException("User email can't be null");

        } else if (password.trim().isEmpty()) {

            throw new IllegalArgumentException("User name must be filled");
        }
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMINISTRATOR) return List.of(new SimpleGrantedAuthority("Administrator"));
        if (this.role == UserRole.CUSTOMER_MANAGER) return List.of(new SimpleGrantedAuthority("Customer_Manager"));
        if (this.role == UserRole.CANDIDATE) return List.of(new SimpleGrantedAuthority("Candidate"));
        else return List.of(new SimpleGrantedAuthority("Operator"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name.toString();
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User { ");
        sb.append("Email:'").append(email).append('\'');
        sb.append(", Name:'").append(name).append('\'');
        sb.append(", Enabled: ").append(enabled);
        sb.append(", Role: ").append(role);
        sb.append('}');
        return sb.toString();
    }

    public void activateUser() {
        this.enabled = true;
    }

    public void deactivateUser() {
        this.enabled = false;
    }

}
