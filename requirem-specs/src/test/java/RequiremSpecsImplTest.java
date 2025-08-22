import junit.framework.TestCase;

public class RequiremSpecsImplTest extends TestCase {

    final String configFile ="docs/config-files/req-specs.csv";
    final String validInputFile ="docs/test-files/valid-req-test-file.txt";
    final String validInputFile2 ="docs/test-files/valid-req-test-file-2.txt";
    final String invalidInputFile ="docs/test-files/invalid-req-test-file.txt";
    final String templateFile ="req-template.txt";
    final RequiremSpecsImpl requiremSpecs = new RequiremSpecsImpl();

    public void testValidFileSyntax() {

        assertTrue(requiremSpecs.validateFileSyntax(validInputFile));
    }

    public void testInvalidFileSyntax() {

        assertFalse(requiremSpecs.validateFileSyntax(invalidInputFile));
    }

    public void testGenerateTemplate() {
        requiremSpecs.generateTemplate(configFile, templateFile);
    }

    public void testEvaluateFileAllRequirementsMet() {

        assertTrue(requiremSpecs.evaluateFile(configFile, validInputFile));
    }

    public void testEvaluateFileNotAllRequirementsMet() {

        assertFalse(requiremSpecs.evaluateFile(configFile, validInputFile2));
    }
}