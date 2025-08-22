package utils.plugins;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader {

    public Class<?> getPluginClass(Plugin plugin) {

        String executablePath = plugin.getExecutablePath();
        String implementationClass = plugin.getImplClass();
        try {

            URL[] urls={ new URL("file:" + executablePath) };
            URLClassLoader classLoader=new URLClassLoader(urls);

            return Class.forName(implementationClass, true, classLoader);

        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Plugin implemention class not found!");
    }
}
