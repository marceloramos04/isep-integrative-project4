package candidate.countTopNWords;

import candidate.countTopNWords.TopNWordCountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopNWordCountUI implements Runnable {

    @Autowired
    TopNWordCountController top20WordsController;

    @Override

    public void run() {

        List<String> files = List.of("jobs4u.backoffice/src/main/java/candidate/retrieveTopNWords/file", "jobs4u.backoffice/src/main/java/candidate/retrieveTopNWords/file1", "jobs4u.backoffice/src/main/java/candidate/retrieveTopNWords/file2");

        try {
            List<Word> words = top20WordsController.retrieveTop20Words(files);
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
    }
}
