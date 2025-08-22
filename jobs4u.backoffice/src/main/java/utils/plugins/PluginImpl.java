package utils.plugins;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class PluginImpl implements Plugin {

    @Id
    private String executablePath;
    private String description;
    private String implClass;
    @Getter
    private String configFile;

    protected PluginImpl() {
    }

    public PluginImpl(String description, String executablePath, String implClass, String configFile) {
        this.description = description;
        this.executablePath = executablePath;
        this.implClass = implClass;
        this.configFile = configFile;
    }

    @Override
    public String getExecutablePath() {
        return executablePath;
    }

    @Override
    public String getImplClass() {
        return implClass;
    }
}
