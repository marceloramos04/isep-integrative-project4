package candidate.countTopNWordsTest;

import candidate.countTopNWords.TopNWordCountController;
import candidate.countTopNWords.Word;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CountTopNWordsTest {

    @Test
    public void TopNWordCountTest() {
        boolean fail = false;
        List<Word> words = new ArrayList<>();
        TopNWordCountController top20WordsController = new TopNWordCountController();

        List<String> files = List.of("src/main/java/candidate/countTopNWords/file",
                "src/main/java/candidate/countTopNWords/file1",
                "src/main/java/candidate/countTopNWords/file2");

        try {
            words = top20WordsController.retrieveTop20Words(files);
            System.out.println("TOP 20 WORD COUNT:");
            if (words.size() >= 20) {
                for (int i = 0; i < 20; ++i) {
                    System.out.println("-------------------------");
                    System.out.println("" + (i + 1) + ") WORD: " + ((Word) words.get(i)).getWord() + "\nWas mentioned: " + ((Word) words.get(i)).getCount() + " times\nMentioned in files: " + words.get(i).getFiles());

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!words.isEmpty()) {
            for (int i = 0; i < words.size() - 1; i++) {
                int first = words.get(i).getCount();
                int nexti = i++;
                int next = words.get(nexti).getCount();
                if (first < next) fail = true;
            }

            assertFalse(fail);

        }
    }
}
