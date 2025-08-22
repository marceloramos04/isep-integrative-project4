package eapli.jobs4u.app.backoffice;

import menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackages = {"application", "menu", "candidate", "jobOpening", "userManagement", "customer", "eapli.jobs4u.app.backoffice", "interview", "requirements", "utils"})
@EntityScan({"application.domain", "userManagement.domain", "candidate.domain", "jobOpening.domain", "customer.domain", "utils"})
@EnableJpaRepositories(basePackages = {"application", "candidate", "jobOpening", "userManagement", "customer", "utils"})
public class Jobs4uBackoffice implements CommandLineRunner {

    @Autowired
    private MainMenu mainMenu;
    @Autowired
    private Bootstrap bootstrap;
    private static final Logger LOG = LoggerFactory.getLogger(Jobs4uBackoffice.class);

    public static final String PROPERTIES_FILE = "application.properties";

    public static final String DATASSOURCE_URL_KEY = "spring.datasource.url";
    public static final String DATASSOURCE_USERNAME_KEY = "spring.datasource.username";
    public static final String DATASSOURCE_PASSWORD_KEY = "spring.datasource.password";

    public static void main(String[] args) {

        Properties properties = PropertiesLoader.loadProperties(PROPERTIES_FILE);
        if (properties == null) {
            System.err.println("Unable to load properties");

        } else {
            //String url = "jdbc:h2:file:./jobs4u_backoffice_db";
            String url = properties.getProperty(DATASSOURCE_URL_KEY);
            System.out.println("database url: " + url);

            //String username = "teste";
            String username = properties.getProperty(DATASSOURCE_USERNAME_KEY);
            System.out.println("database username: " + username);

            //String password = "teste1";
            String password = properties.getProperty(DATASSOURCE_PASSWORD_KEY);
            System.out.println("database password: " + password);

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                System.out.println("Connected to the database.");

            } catch (SQLException e) {

                System.out.println("Connection failed.");
                e.printStackTrace();
            }
        }

        LOG.info("1.STARTING : Spring boot application starting");

        SpringApplication.run(Jobs4uBackoffice.class, args);

        LOG.info("3.STOPPED  : Spring boot application stopped");
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("2.EXECUTING : command line runner");

        bootstrap.run();
        mainMenu.run();
    }
}
