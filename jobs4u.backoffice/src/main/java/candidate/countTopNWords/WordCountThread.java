package candidate.countTopNWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCountThread extends Thread {

    private static final Pattern LETTERS_ONLY = Pattern.compile("[^a-zA-Z]+");
    Map<String, Integer> top20 = new HashMap();
    String file;
    List<Word> wordsList = new ArrayList();
    // private final Object lock;
    private final TopNWordCountController controller;

    public WordCountThread(String file, TopNWordCountController controller) {
        this.file = file;
        this.controller = controller;
    }

    public void run() {
        Map<String, Integer> map = new HashMap();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                List<String> words2 = Arrays.asList(words);
                words2 = removeNulls(words2);
                int length = words.length;

                for (String word : words2) {
                    word = LETTERS_ONLY.matcher(word).replaceAll("").toLowerCase();
                    if (!word.isEmpty()) {
                        if (!map.containsKey(word)) {
                            map.put(word, 1);
                        } else {
                            map.put(word, (Integer) map.get(word) + 1);
                        }
                    }
                }
            }
            reader.close();
            this.getTop20Words(map);
            this.orderTop20();

            synchronized (controller) {
                controller.threadFinished();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    private void orderTop20() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(this.top20.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            this.wordsList.add(new Word(entry.getKey(), entry.getValue(), this.file));
        }
    }

    private void getTop20Words(Map<String, Integer> map) {
        for (int i = 0; i < 20; ++i) {
            int higherCount = 0;
            String word = null;

            for (String w : map.keySet()) {
                if (map.get(w) > higherCount) {
                    higherCount = map.get(w);
                    word = w;
                }
            }

            if (word != null) {
                map.remove(word);
                this.top20.put(word, higherCount);
            }
        }

    }

    public List<Word> getWordList() {
        return this.wordsList;
    }

    public List<String> removeNulls(List<String> list) {

        for(String s:list){
            if (s== null) {
                list.remove(s);
            }
        }
        return list;
    }

}
