package EPAMCoding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "ParulDhingraP";
        System.out.println("First Non Repeating Character is : " + getFirstNonRepeatingCharacter(input));
        System.out.println("First Non Repeating Character using LinkedHashMap is : " + getFirstNonRepeatingCharacterUsingLinkedHashMap(input));
        System.out.println("First Non Repeating Character using LinkedHashMap and streams is : " + getFirstNonRepeatingCharacterUsingLinkedHashMapAndStreams(input));
    }

    private static Character getFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(Character s: input.toCharArray()) {
            freqMap.put(s, freqMap.getOrDefault(s,0)+1);
        }
        for(Character s: input.toCharArray()) {
            if(freqMap.get(s) == 1) {
                return s;
            }
        }
        return null;
    }

    private static Character getFirstNonRepeatingCharacterUsingLinkedHashMap(String input) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for(Character s: input.toCharArray()) {
            freqMap.put(s, freqMap.getOrDefault(s,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static Character getFirstNonRepeatingCharacterUsingLinkedHashMapAndStreams(String input) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for(Character s: input.toCharArray()) {
            freqMap.put(s, freqMap.getOrDefault(s,0)+1);
        }
        return freqMap.entrySet()
                .stream()
                .filter(a -> a.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
