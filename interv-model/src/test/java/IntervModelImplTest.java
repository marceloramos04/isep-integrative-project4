import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntervModelImplTest {

    final String configFile ="docs/config-files/interv-model.csv";
    final String validInputFile ="docs/test-files/valid-interv-test-file.txt";
    final String validInputFile2 ="docs/test-files/valid-interv-test-file-2.txt";
    final String invalidInputFile ="docs/test-files/invalid-interv-test-file.txt";
    final String templateFile ="interv-template.txt";
    final IntervModelImpl IntervModel = new IntervModelImpl();

    @Test
    public void testInvalidFileSyntax() {
        assertFalse(IntervModel.validateFileSyntax(invalidInputFile));
    }

    @Test
    public void testGenerateTemplate() {
        IntervModel.generateTemplate(configFile, templateFile);
    }

    @Test
    public void evaluateFile2() {
        assertEquals(23, IntervModel.evaluateFile(configFile, validInputFile));
    }

    @Test
    public void evaluateFile3() {
        assertEquals(26, IntervModel.evaluateFile(configFile, validInputFile2));
    }
}