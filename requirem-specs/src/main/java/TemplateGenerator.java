import requirement.RequiremType;
import requirement.Requirement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TemplateGenerator {

    public void generateTemplate(String requiremSpecsFile, String outputFile){

        ArrayList<Requirement> reqs=new RequirementsLoader().getRequirementsFromFile(requiremSpecsFile);
        exportFile(reqs, outputFile);
    }

    private void exportFile(ArrayList<Requirement> reqs, String outputFile){

        try {
            Formatter out=new Formatter(outputFile);

            try {
                for (Requirement r: reqs) {

                    String possibleAnswers=getSimpleStringFromArray(r.getPossibleAnswers());
                    String expectedAnswers=getSimpleStringFromArray(r.getExpected());

                    out.format("# %s (%s)\n", r.getComment(), possibleAnswers);
                    out.format("%s: %s\n\n", r.getDescription(), expectedAnswers);
                }
            } finally {
                out.close();
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private String getSimpleStringFromArray(String[] array){
        StringBuilder simpleString= new StringBuilder();
        for (int i=0; i < array.length; i++){
            if (i == 0){
                simpleString = new StringBuilder(array[i]);
            } else {
                simpleString.append(", ").append(array[i]);
            }
        }
        return simpleString.toString();
    }
}
