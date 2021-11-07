import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo19WordCountJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Scala/data/words.txt"));
        String line;
        HashMap<String, Integer> wordsMap = new HashMap<>();
        while ((line = br.readLine()) != null) {
            //切分
            String[] split = line.split(",");
            for (String word : split) {
                //如果不存在该单词，则将其插入
                if (!wordsMap.containsKey(word)) {
                    wordsMap.put(word, 0);
                }
                Integer i = wordsMap.get(word);
                int i1 = i + 1;
                wordsMap.put(word, i1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        br.close();
    }
}
