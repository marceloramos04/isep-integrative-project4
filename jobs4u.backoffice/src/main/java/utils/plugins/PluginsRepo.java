package utils.plugins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PluginsRepo extends JpaRepository<PluginImpl, Integer> {

    boolean existsByExecutablePath(String executable);

    PluginImpl findByExecutablePath(String executable);
}
