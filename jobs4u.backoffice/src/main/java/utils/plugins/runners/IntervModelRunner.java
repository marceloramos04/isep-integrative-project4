package utils.plugins.runners;

import eapli.jobs4u.app.backoffice.Jobs4uBackoffice;
import eapli.jobs4u.app.backoffice.PropertiesLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import requirem_specs.IntervModel;
import requirem_specs.RequiremSpecs;
import utils.plugins.PluginClassLoader;
import utils.plugins.PluginImpl;
import utils.plugins.PluginsRepo;

import java.util.Properties;

@Component
public class IntervModelRunner {

    @Autowired
    private PluginsRepo pluginsRepo;
    private final String EXECUTABLE_PROPERTY_KEY = "plugin.interv_model.executable";
    private PluginImpl plugin;
    private IntervModel eval;
    private boolean isSetup = false;

    public void setup(){
        Properties properties = PropertiesLoader.loadProperties(Jobs4uBackoffice.PROPERTIES_FILE);
        try {
            String executable = properties.getProperty(EXECUTABLE_PROPERTY_KEY);
            plugin = pluginsRepo.findByExecutablePath(executable);

            Class<?> implClass = new PluginClassLoader().getPluginClass(plugin);
            eval = (IntervModel) implClass.getDeclaredConstructor().newInstance();
            isSetup = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateFileSyntax(String inputFile) {
        if (!isSetup) setup();
        return eval.validateFileSyntax(inputFile);
    }

    public void generateTemplate(String outputFile){
        if (!isSetup) setup();
        eval.generateTemplate(plugin.getConfigFile(), outputFile);
    }

    public double evaluateFile(String inputFile){
        if (!isSetup) setup();
        return eval.evaluateFile(plugin.getConfigFile(), inputFile);
    }
}
