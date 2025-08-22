package question;

import java.util.ArrayList;

public class Question {

    String question;
    QuestionType type;
    Answer[] configAnswers;
    String[] options;

    public Question(String question, QuestionType type, Answer[] configAnswers, String[] options) {
        this.question = question;
        this.type = type;
        this.configAnswers = configAnswers;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionType getType() {
        return type;
    }

    public Answer[] getConfigAnswers() {
        return configAnswers;
    }

    public String[] getOptions() {
        return options;
    }

    public String[] getQuestionOptions() {
        if (type.equals(QuestionType.multiple_choice) || type.equals(QuestionType.single_choice)) {
            return this.options;
        }

        String[] options = new String[configAnswers.length];
        for (int i = 0; i < configAnswers.length; i++) {
            options[i] = configAnswers[i].getComponents()[0];
        }
        return options;
    }
}
