package candidate.countTopNWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    String word;
    List<String> files = new ArrayList<>();
    int count = 0;

    public Word(String word, String file) {
        this.word = word;
        this.files.add(file);
    }

    public Word(String word, int count, String file) {
        this.word = word;
        this.files.add(file);
        this.count = count;
    }

    public String getWord() {
        return this.word;
    }

    public List<String> getFiles() {
        return this.files;
    }

    public int getCount() {
        return this.count;
    }

    public void addCount() {
        ++this.count;
    }

    public void addFile(String file) {
        this.files.add(file);
    }


    public void addToCount(int value) {
        this.count += value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Word word1 = (Word) o;
            return Objects.equals(this.getWord(), word1.getWord());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.getWord());
    }

    public String toString() {
        return "Word{word='" + this.word + "', count=" + this.count + ", file='" + this.files + "'}";
    }
}
