package requirem_specs;

public interface IntervModel {

    boolean validateFileSyntax(String inputFile);
    void generateTemplate(String configFile, String outputFile);
    double evaluateFile(String configFile, String inputFile);
}
