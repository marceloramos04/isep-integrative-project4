import question.Answer;
import question.Question;
import question.QuestionType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionsLoader {

    public ArrayList<Question> getModelQuestions(String configFile){

        ArrayList<Question> questions=new ArrayList<>();

        try {

            Scanner in=new Scanner(new File(configFile));
            in.nextLine();

            while(in.hasNextLine()){

                String line=in.nextLine();
                String[] parts=line.split(";");

                QuestionType type=QuestionType.valueOf(parts[0].trim());
                String question=parts[1].trim();

                String[] ansStrings=parts[2].split(",");
                Answer[] ansObjs=new Answer[ansStrings.length];

                for (int i=0; i < ansStrings.length; i++){

                    String[] ansAndGrades=ansStrings[i].split("=");

                    String[] ansComponents=ansAndGrades[0].split("&");
                    for (int j=0; j<ansComponents.length; j++){
                        ansComponents[j]=ansComponents[j].trim();
                    }

                    int grade=Integer.parseInt(ansAndGrades[1]);
                    ansObjs[i]=new Answer(ansComponents, grade);
                }

                String[] options=new String[0];

                if (type.equals(QuestionType.multiple_choice) || type.equals(QuestionType.single_choice)){
                    options=parts[3].split(",");
                    for (int i=0; i<options.length; i++){
                        options[i]=options[i].trim();
                    }
                }

                Question q=new Question(question, type, ansObjs, options);
                questions.add(q);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        return questions;
    }
}
