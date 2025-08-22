import gen.JobRequirementsBaseListener;
import gen.JobRequirementsParser;
import requirement.RequiremType;
import requirement.Requirement;

import java.util.ArrayList;
import java.util.Arrays;

public class EvalListener extends JobRequirementsBaseListener {

    private ArrayList<Boolean> partialResults = new ArrayList<>();

    public boolean getResult() {
        for (Boolean b : partialResults) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void enterRequirement(JobRequirementsParser.RequirementContext ctx) {

        String reqDescrip = ctx.descrip.getText();
        ArrayList<Requirement> reqsSpecs = new RequirementsLoader().getRequirementsFromFile(RequiremSpecsImpl.configFile);
        Requirement expectedReq = getMatchingRequirement(reqDescrip, reqsSpecs);
        if (expectedReq==null){
            throw new RuntimeException(String.format("Requirement '%s' not found in requirements file", reqDescrip));
        }

        RequiremType type = expectedReq.getType();
        String[] expectedAnswer = expectedReq.getExpected();
        System.out.printf("Expected answer for '%s': %s\n", reqDescrip, Arrays.toString(expectedAnswer));

        String actual = ctx.answer().getText();
        System.out.println("Actual answer: " + actual);

        boolean result;

        switch (type) {
            case num_int:
                int expected_int = Integer.parseInt(expectedAnswer[0]);
                int actual_int = Integer.parseInt(actual);
                result = processIntAnswer(expected_int, actual_int);
                if (!result) System.err.printf("É exigido um mínimo de %d para %s\n", expected_int, reqDescrip);
                break;

            case num_float:
                double expected_float = Float.parseFloat(expectedAnswer[0]);
                double actual_float = Float.parseFloat(actual);
                result = processFloatAnswer(expected_float, actual_float);
                if (!result) System.err.printf("É exigido um mínimo de %.1f para %s\n", expected_float, reqDescrip);
                break;

            case exact:
                result = processExactAnswer(expectedAnswer[0], actual);
                if (!result) System.err.printf("É exigido %s para %s\n", expectedAnswer[0], reqDescrip);
                break;

            case multiple:
                result = processMultipleAnswer(expectedAnswer, actual);
                if (!result) System.err.printf("São exigidos %s para %s\n", Arrays.toString(expectedAnswer), reqDescrip);
                break;

            default:
                result = processOrderAnswers(expectedReq, expectedAnswer[0], actual);
                if (!result) System.err.printf("É exigido %s ou superior para %s\n", expectedAnswer[0], reqDescrip);
                break;
        }

        partialResults.add(result);
        if (result) {
            System.out.println("Passed!\n");
        } else {
            System.err.println("Didn't pass!\n");
        }
    }

    public Requirement getMatchingRequirement(String reqDescrip, ArrayList<Requirement> answer) {

        for (Requirement r : answer) {
            if (r.getDescription().equalsIgnoreCase(reqDescrip)) {
                return r;
            }
        }

        return null;
    }

    public boolean processIntAnswer(int expected, int actual) {
        System.out.println("Requirement type: " + RequiremType.num_int);
        return actual >= expected;
    }

    public boolean processFloatAnswer(double expected, double actual) {
        System.out.println("Requirement type: " + RequiremType.num_float);
        return actual >= expected;
    }

    public boolean processExactAnswer(String expected, String actual) {
        System.out.println("Requirement type: " + RequiremType.exact);
        return expected.equalsIgnoreCase(actual);
    }

    public boolean processMultipleAnswer(String[] expected, String actual) {
        System.out.println("Requirement type: " + RequiremType.multiple);
        for (int i = 0; i < expected.length; i++) {
            expected[i] = expected[i].trim();
        }

        String[] actualList = actual.split(",");
        for (int i = 0; i < actualList.length; i++) {
            actualList[i] = actualList[i].trim();
        }

        boolean allFound = true;

        for (String e : expected) {

            System.out.println("Checking for: " + e);

            boolean found = false;

            for (String a : actualList) {
                if (e.equalsIgnoreCase(a)) {
                    found = true;
                    break;
                }
            }

            System.out.println("Found: " + found);

            if (!found) {
                allFound = false;
                break;
            }
        }

        return allFound;
    }

    public boolean processOrderAnswers(Requirement expectedReq, String expected, String actual) {
        System.out.println("Requirement type: " + RequiremType.order);
        int expectedIndex = -1;
        int actualIndex = -1;
        String[] options= expectedReq.getPossibleAnswers();

        for (int i = 0; i < options.length; i++) {
            if (options[i].trim().equalsIgnoreCase(expected)) {
                expectedIndex = i;
            }
            if (options[i].trim().equalsIgnoreCase(actual)) {
                actualIndex = i;
            }

        }

        if (expectedIndex == -1 || actualIndex == -1) {
            return false;
        } else {
            return actualIndex >= expectedIndex;
        }
    }
}
