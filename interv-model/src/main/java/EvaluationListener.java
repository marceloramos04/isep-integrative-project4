import gen.IntervModelBaseListener;
import gen.IntervModelParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import question.Answer;
import question.Question;
import question.QuestionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluationListener extends IntervModelBaseListener {

    private double grade=0;
    private final int EACH_QUESTION_GRADE = 10;
    private final int DEFAULT_GRADE = 0;

    public double getGrade(){
        return grade;
    }

    @Override
    public void enterQuestion(IntervModelParser.QuestionContext ctx) {

        ArrayList<Question> questions= new QuestionsLoader().getModelQuestions(IntervModelImpl.configFile);

        List<TerminalNode> inputQuestionParts = ctx.questionDescrip().descrip.TEXT();
        String inputQuestion=inputQuestionParts.get(0).getText();
        for (int i=1; i<inputQuestionParts.size(); i++){
            inputQuestion+=" "+inputQuestionParts.get(i).getText();
        }
        System.out.println("Question: "+inputQuestion);

        Question question = findQuestion(inputQuestion, questions);
        String inputAnswer = ctx.answer().answer_c.getText();

        if (question==null){
            System.err.println("Question " + inputQuestionParts + "not found in model file");
            return;
        }

        double questionGrade=0;

        if (question.getType().equals(QuestionType.multiple_choice)){
            questionGrade=processMultipleAnswer(question, inputAnswer);

        } else if (question.getType().equals(QuestionType.single_choice)){
            questionGrade=processSingleAnswer(question, inputAnswer);

        } else {
            questionGrade=processOtherTypeOfAnswer(question, inputAnswer);
        }

        grade+=questionGrade;

        System.out.printf("Grade : %.2f\n\n", questionGrade);
    }

    public Question findQuestion(String question, ArrayList<Question> questions){
        for (Question q: questions){
            if (q.getQuestion().trim().equalsIgnoreCase(question.trim())){
                return q;
            }
        }
        return null;
    }

    public double processMultipleAnswer(Question question, String inputAnswer){
        String[] inputAnswerComponentsIndexes= inputAnswer.split(",");

        String[] inputAnswerComponents=new String[inputAnswerComponentsIndexes.length];
        for (int i=0; i<inputAnswerComponents.length; i++){
            inputAnswerComponents[i]=question.getQuestionOptions()[Integer.parseInt(inputAnswerComponentsIndexes[i])-1];
        }

        System.out.printf("Input Answer: %s\n", Arrays.toString(inputAnswerComponents));

        double questionGrade=DEFAULT_GRADE;

        for (Answer configAns: question.getConfigAnswers()){

            String[] configAsnComp = configAns.getComponents();
            boolean match=areArraysEqual(inputAnswerComponents, configAsnComp);

            if (match){
                questionGrade= (double) configAns.getPercentage() /100 * EACH_QUESTION_GRADE;
                System.out.println("Matched answer: "+ Arrays.toString( configAns.getComponents()));
                break;
            }
        }

        return questionGrade;
    }

    public double processSingleAnswer(Question question, String inputAnswerIndex){
        String inputAnswer=question.getQuestionOptions()[Integer.parseInt(inputAnswerIndex)-1];
        System.out.printf("Input Answer: %s\n", inputAnswer);
        double questionGrade=DEFAULT_GRADE;

        for (Answer configAns: question.getConfigAnswers()){
            if (configAns.getComponents()[0].trim().equalsIgnoreCase(inputAnswer.trim())){
                questionGrade=(double) configAns.getPercentage() /100 * EACH_QUESTION_GRADE;
                System.out.println("Matched answer: "+ Arrays.toString( configAns.getComponents()));
            }
        }

        return questionGrade;
    }

    public double processOtherTypeOfAnswer(Question question, String inputAnswer){
        System.out.printf("Input Answer: %s\n", inputAnswer);
        double questionGrade=DEFAULT_GRADE;

        for (Answer configAns: question.getConfigAnswers()){
            if (configAns.getComponents()[0].trim().equalsIgnoreCase(inputAnswer.trim())){
                questionGrade=(double) configAns.getPercentage() /100 * EACH_QUESTION_GRADE;
            }
        }

        return questionGrade;
    }

    public boolean areArraysEqual(String[] arr1, String[] arr2) {
        // Verificar se ambos os arrays são nulos
        if (arr1 == null && arr2 == null) {
            return true;
        }

        // Verificar se um dos arrays é nulo
        if (arr1 == null || arr2 == null) {
            return false;
        }

        // Verificar se os arrays têm comprimentos diferentes
        if (arr1.length != arr2.length) {
            return false;
        }

        // Fazer uma cópia dos arrays para não modificar os originais
        String[] sortedArr1 = Arrays.copyOf(arr1, arr1.length);
        String[] sortedArr2 = Arrays.copyOf(arr2, arr2.length);

        // Ordenar ambos os arrays
        Arrays.sort(sortedArr1);
        Arrays.sort(sortedArr2);

        // Comparar os arrays ordenados elemento por elemento
        boolean equal=true;
        for (int i = 0; i < sortedArr1.length; i++) {
            if (!sortedArr1[i].trim().equalsIgnoreCase(sortedArr2[i].trim())){
                equal=false;
                break;
            }
        }

        return equal;
    }


}
