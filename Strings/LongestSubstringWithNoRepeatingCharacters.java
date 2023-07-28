package Strings;


import java.util.HashMap;

/*Given a string s, find the length of the longest substring without repeating characters.


        Example:
        Input: s = "pwwkew"
        Output: kew
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring*/
public class LongestSubstringWithNoRepeatingCharacters {
    public static void main(String[] args) {
        String parent = "pwwkew";
        System.out.println(getStringWithNoRepeatingCharacter1(parent));
        System.out.println(getStringWithNoRepeatingCharacter2(parent));
    }

    static int getStringWithNoRepeatingCharacter1(String parent){
        int start = 0, end = 0;
        int maxCount = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (end< parent.length()){
            char charEnd = parent.charAt(end);
            if(!hashMap.containsKey(charEnd)){
                hashMap.put(charEnd, 1);
                maxCount = Math.max(maxCount, end-start+1);
            } else {
                while (hashMap.containsKey(charEnd)){
                    hashMap.remove(parent.charAt(start));
                    start++;
                }
                hashMap.put(charEnd, 1);
            }
            end++;
        }
        return maxCount;
    }

    static int getStringWithNoRepeatingCharacter2(String parent){
        int start = 0, end = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (end< parent.length()){
            char charEnd = parent.charAt(end);
            if(hashMap.containsKey(charEnd)){
                hashMap.put(charEnd, hashMap.get(charEnd)+1);
            } else {
                hashMap.put(charEnd, 1);
            }
            while(hashMap.size() < end-start+1){
                char charStart = parent.charAt(start);
                hashMap.put(charStart, hashMap.get(charStart)-1);
                if (hashMap.get(charStart) == 0){
                    hashMap.remove(charStart);
                }
                start++;
            }
            end++;
        }
        return hashMap.size();
    }
}
