package Strings;

/*Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

        Example 1:

        Input:
        txt = forxxorfxdofr
        pat = for
        Output: 3
        Explanation: for, orf and ofr appears
        in the txt, hence answer is 3.
        Example 2:

        Input:
        txt = aabaabaa
        pat = aaba
        Output: 4
        Explanation: aaba is present 4 times
        in txt.*/

import java.util.HashMap;

public class CountOccurrenceAnagrams {
    public static void main(String[] args) {
        String parent = "aabaabaa";
        String child = "aaba";
        System.out.println(getAnagramOccurrenceCount(parent, child));
    }

    static int getAnagramOccurrenceCount(String parent, String child){
        int result = 0, count = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int windowSize = child.length();
        int start = 0, end = 0;
        //Iterating for count and hashmap
        for(int i=0;i<windowSize;i++){
            char ch = child.charAt(i);
            if(hashMap.get(ch) == null){
                count++;
                hashMap.put(ch, 1);
            } else{
                hashMap.put(ch, hashMap.get(ch)+1);
            }
        }
        //Now to check on Parent
        while (end<parent.length()){
            char charEnd = parent.charAt(end);
            char charStart = parent.charAt(start);
            if(hashMap.containsKey(charEnd)){
                hashMap.put(charEnd, hashMap.get(charEnd)-1);
                if(hashMap.get(charEnd) == 0){
                    count--;
                }
            }
            if(end-start+1 == windowSize){
                if(count == 0){
                    result++;
                }
                if(hashMap.containsKey(charStart)){
                    hashMap.put(charStart, hashMap.get(charStart)+1);
                    if(hashMap.get(charStart) ==1){
                        count++;
                    }
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
