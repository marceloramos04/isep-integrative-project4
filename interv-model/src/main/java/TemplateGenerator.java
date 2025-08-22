import question.Answer;
import question.Question;
import question.QuestionType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TemplateGenerator {

    public void generateTemplate(String configFile, String outputPath) {
        ArrayList<Question> questions=new QuestionsLoader().getModelQuestions(configFile);

        try {
            PrintWriter out = new PrintWriter(outputPath);

            try {

                for (Question q: questions){
                    out.print(getQuestionString(q));
                }

            } finally {
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getQuestionString(Question q){
        StringBuilder s=new StringBuilder();
        s.append("Q: ");
        s.append(q.getQuestion());
        s.append("\n");

        if (q.getType().equals(QuestionType.multiple_choice) || q.getType().equals(QuestionType.single_choice)) {

            String[] questionOptions = q.getQuestionOptions();
            for (int i=0; i < questionOptions.length; i++){
                s.append(i+1).append(". ").append(questionOptions[i]).append("\n");
            }

        }

        s.append("A: ").append("(your answer)").append("\n\n");
        return s.toString();
    }
}
