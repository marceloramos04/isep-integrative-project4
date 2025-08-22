package eapli.jobs4u.app.backoffice;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String propertiesFile) {

        InputStream in = Jobs4uBackoffice.class.getClassLoader().getResourceAsStream(propertiesFile);

        if (in == null) {
            System.err.println("Unable to find application.properties file");

        } else {

            Properties properties = new Properties();

            try {
                properties.load(in);
                return properties;

            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }

        return null;
    }
}
