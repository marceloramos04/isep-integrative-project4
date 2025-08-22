package question;

public class Answer {

    private String[] components;
    private int percentage;

    public Answer(String[] components, int percentage) {
        this.components = components;
        this.percentage = percentage;
    }

    public String[] getComponents() {
        return components;
    }

    public int getPercentage() {
        return percentage;
    }
}
