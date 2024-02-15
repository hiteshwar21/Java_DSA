package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequency {
    public static void main(String[] args) {
        String word = "PublicisSapient";
        countAlphabetCount(word);
    }

    static void countAlphabetCount(String word) {
        if(word.isEmpty()){
            System.out.println("Given word is empty");
            return;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            freq.put(word.charAt(i), freq.getOrDefault(word.charAt(i), 0)+1);
        }
        Map<Character, Integer> nonZeroMap = freq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(nonZeroMap);
    }
}