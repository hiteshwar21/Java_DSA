package Strings;

import java.util.HashMap;

/*Given a string you need to print the size of the longest possible substring that has exactly k unique characters.
        Example:
        Input:
        2
        aabacbebebe
        3
        aaaa
        1
        Output:
        7
        4 .*/
public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String parent = "aabacbebebe";
        int uniqueCharCount = 3;
        System.out.println(getLongestSubstringWithUniqueCharacters(parent, uniqueCharCount));
    }

    static int getLongestSubstringWithUniqueCharacters(String parent, int desiredCount){
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        while(end<parent.length()){
            char charEnd = parent.charAt(end);
            map.put(charEnd, map.getOrDefault(charEnd,0) + 1);
            if(map.size() == desiredCount){
                maxCount = Math.max(maxCount, end-start+1);
            }
            while (map.size() > desiredCount){
                    char charStart = parent.charAt(start);
                    map.put(charStart, map.get(charStart)-1);
                    if(map.get(charStart) == 0){
                        map.remove(charStart);
                    }
                    start++;
            }
            end++;
        }
        return maxCount;
    }
}
