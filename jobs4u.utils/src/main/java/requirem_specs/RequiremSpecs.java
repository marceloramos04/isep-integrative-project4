package requirem_specs;

public interface RequiremSpecs {

    boolean validateFileSyntax(String inputFile);
    void generateTemplate(String configFile, String outputFile);
    boolean evaluateFile(String configFile, String inputFile);
}
