package userManagement;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import userManagement.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import userManagement.domain.UserRole;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
    @Transactional
    UserDetails findByEmail(String email);

    @Transactional
    AppUser findById(Long id);

    @Query("SELECT u FROM AppUser u WHERE u.enabled = true")
    List<AppUser> findAllActivatedUsers();

    @Query("SELECT u FROM AppUser u WHERE u.enabled = false")
    List<AppUser> findAllDeactivatedUsers();

    @Transactional
    @Modifying
    @Query("UPDATE AppUser u SET u.enabled = :enabled WHERE u.id = :id")
    void updateUserStatusById(@Param("id") Long id, @Param("enabled") Boolean enabled);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.enabled = true")
    List<AppUser> findAllActivatedCandidates(@Param("role") UserRole role);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.enabled = false")
    List<AppUser> findAllDeactivatedCandidates(@Param("role") UserRole role);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser u SET u.enabled = :enabled WHERE u.email = :email")
    void updateUserStatusByEmail(@Param("email") String email, @Param("enabled") Boolean enabled);
}
