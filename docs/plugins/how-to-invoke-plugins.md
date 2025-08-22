# HOW TO INVOKE THE PLUGINS

## EXAMPLE CODE

```java

//the key that identifies the wanted plugin executable path in the application.properties file
private final String EXECUTABLE_PROPERTY_KEY = "(to do)";

public void invokePlugin(String inputFileName) throws IOException {

    //get the properties from the application.properties
    //properties like the plugin executable path and the config file path
    Properties properties = PropertiesLoader.loadProperties(Jobs4uBackoffice.PROPERTIES_FILE);

    try {

        String executable = properties.getProperty(EXECUTABLE_PROPERTY_KEY);
        PluginImpl plugin = pluginsRepo.findByExecutablePath(executable);

        Class<?> implClass = new PluginClassLoader().getPluginClass(plugin);
        
        //this example is for a plugin that implements the RequiremSpecs interface, for the a IntervModel it would be IntervModel interface
        RequiremSpecs eval = (RequiremSpecs) implClass.getDeclaredConstructor().newInstance();
        
        //eval.evalutateFile() is the method from the plugin that i want to call that will make the desired job
        boolean result = eval.evaluateFile(plugin.getConfigFile(), inputFileName);

        if (result) {
            System.out.println("All requirements met!\n");
        } else {
            System.out.println("Not all requirements met!\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

## CLASSES AND INTERFACES

### RequiremSpecs and IntervModel interfaces

These are the interfaces that specifies the expected tasks for the Requirements Specifications and Interview Model plugins.
For example, any Interview Model plugin must implement the IntervModel interface, that demands the implementation of the generateTemplate() and evaluateFile() methods, i.e. any interview model plugin must allow you to generate a template file and evaluate a file.

[RequiremSpecs.java](../../jobs4u.utils/src/main/java/requirem_specs/RequiremSpecs.java)

[IntervModel.java](../../jobs4u.utils/src/main/java/requirem_specs/IntervModel.java)

### Plugin interface

This is a interface that specifies the common behaviors that any plugin registered in the system must support, like provide the executable path and the name of the class that implements the expected behavior.

[Plugin.java](../../jobs4u.backoffice/src/main/java/utils/plugins/Plugin.java)

### PluginImpl class

This is a class that represents a plugin registered in the system. It is a class that holds a plugin's name, executable path and name of the class that implements the expected behavior.

[PluginImpl.java](../../jobs4u.backoffice/src/main/java/utils/plugins/PluginImpl.java)

### PluginsRepo class

Repository of all the plugins registered in the system.

[PluginsRepo.java](../../jobs4u.backoffice/src/main/java/utils/plugins/PluginsRepo.java)

### PluginClassLoader class

This class was implemented to return the class that implements the expected behavior of a plugin.
For example, given an interview model plugin, the plugin itself has a class A that implements the IntervModel interface, so this class was designed to return the class A.

[PluginClassLoader.java](../../jobs4u.backoffice/src/main/java/utils/plugins/PluginClassLoader.java)