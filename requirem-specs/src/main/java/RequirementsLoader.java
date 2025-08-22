import requirement.RequiremType;
import requirement.Requirement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RequirementsLoader {

    public ArrayList<Requirement> getRequirementsFromFile(String inputFile){
        ArrayList<Requirement> reqs=new ArrayList<>();

        try {
            Scanner in=new Scanner(new File(inputFile));
            in.nextLine();

            while(in.hasNextLine()){
                Requirement r=getRequirementObj(in.nextLine());
                reqs.add(r);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return reqs;
    }

    private Requirement getRequirementObj(String s){
        String[] parts=s.split(";");

        String description=parts[0].trim();
        RequiremType type=null;

        for (RequiremType other: RequiremType.values()){
            if (other.toString().equalsIgnoreCase(parts[1].trim())){
                type=other;
            }
        }

        if (type==null){
            throw new RuntimeException("Invalid requirement type specified in requirements specification file");
        }

        String[] expected=parts[2].split(",");
        for (int i=0; i < expected.length; i++){
            expected[i]=expected[i].trim();
        }

        String[] possibleAnswers=parts[3].split(",");
        for (int i=0; i < possibleAnswers.length; i++){
            possibleAnswers[i]=possibleAnswers[i].trim();
        }

        String comment=parts[4].trim();

        return new Requirement(description, type, expected, possibleAnswers, comment);
    }
}
