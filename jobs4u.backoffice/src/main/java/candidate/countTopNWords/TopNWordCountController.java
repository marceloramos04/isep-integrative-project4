package candidate.countTopNWords;

import candidate.countTopNWords.WordCountThread;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TopNWordCountController {

    private final Object lock = new Object();
    private int activeThreads = 0;

    public List<Word> retrieveTop20Words(List<String> files) throws InterruptedException {

        Set<Word> wordSet = new HashSet();
        List<Thread> threads = new ArrayList<>();

        synchronized (lock) {
            for (String file : files) {
                WordCountThread countWords = new WordCountThread(file, this);
                threads.add(countWords);
                countWords.start();
                activeThreads++;

              //  countWords.join();
              //  List<Word> wordList = countWords.getWordList();
            //    updateWordSet(wordSet, wordList);
            }

            while (activeThreads > 0) {
                lock.wait();
            }
        }

        for (Thread thread : threads) {
            WordCountThread countWords = (WordCountThread) thread;
            List<Word> wordList = countWords.getWordList();
            updateWordSet(wordSet, wordList);
        }
        return sortWordsByCount(wordSet);



    }

    private static List<Word> sortWordsByCount(Set<Word> wordSet) {
        List<Word> wordList = new ArrayList(wordSet);
        wordList.sort((w1, w2) -> {
            return Integer.compare(w2.getCount(), w1.getCount());
        });
        return wordList;
    }

    private void updateWordSet(Set<Word> wordSet, List<Word> wordList) {
        Iterator var2 = wordList.iterator();

        while (var2.hasNext()) {
            Word word = (Word) var2.next();
            boolean found = false;
            Iterator var5 = wordSet.iterator();

            while (var5.hasNext()) {
                Word existingWord = (Word) var5.next();
                if (existingWord.getWord().equals(word.getWord())) {
                    for (String file : word.getFiles()) {
                        if (!existingWord.getFiles().contains(file)) {
                            existingWord.addFile(file);
                        }
                    }
                    existingWord.addToCount(word.getCount());
                    found = true;
                    break;
                }
            }

            if (!found) {
                wordSet.add(word);
            }
        }

    }

    public void threadFinished() {
        synchronized (lock) {
            activeThreads--;
            if (activeThreads == 0) {
                lock.notifyAll();      }
        }
    }
}