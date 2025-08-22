package utils;

import jakarta.persistence.Embeddable;

@Embeddable
public class Title {

    private String title;

    public Title(String title) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title should neither be null nor empty");
        }

        if (!checkTitleWords(title)) {
            throw new IllegalArgumentException("Title should have at most 3 words");
        }

        this.title = title;
    }

    protected Title() {

    }

    private boolean checkTitleWords(String title) {
        int count = 0;
        title = title.trim();
        for (int i = 1; i < title.length(); i++) {
            if (title.charAt(i) == ' ' && title.charAt(i - 1) != ' ') {
                count ++;
            }
        }

        return count <= 6; // title should have at most 6 words
    }

    @Override
    public String toString() {
        return title;
    }
}
