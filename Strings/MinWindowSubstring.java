package Strings;

import java.util.HashMap;

/*Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

        Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.



        Example 1:

        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"
        Example 2:

        Input: s = "a", t = "a"
        Output: "a"*/
public class MinWindowSubstring {
    public static void main(String[] args) {
        String parentString = "ABCADOBECODEBANC";
        String minRequiredSubstring  = "ABC";
        System.out.println(getMinWindowSubstring(parentString, minRequiredSubstring));
        System.out.println(getMinWindowSubstring2(parentString, minRequiredSubstring));
        System.out.println(minWindow(parentString, minRequiredSubstring));
    }

    static String getMinWindowSubstring(String parentString, String minRequiredSubstring){
        int start = 0, end = 0;
        HashMap<Character, Integer> requiredMap = new HashMap<>();
        int maxStart = 0, minEnd = 0;
        for(int i=0; i<minRequiredSubstring.length(); i++) {
            char ch = minRequiredSubstring.charAt(i);
            requiredMap.put(ch, requiredMap.getOrDefault(ch, 0)+1);
        }
        int count =requiredMap.size();
        while (end < parentString.length()){
            if(count == 0 && (minEnd ==0 || end-start+1< minEnd-maxStart+1)){
                minEnd = end;
                maxStart = start;
            }
            char charEnd = parentString.charAt(end);
            if (requiredMap.containsKey(charEnd)){
                requiredMap.put(charEnd, requiredMap.get(charEnd)-1);
            }
            char charStart = parentString.charAt(start);
            if(requiredMap.containsKey(charStart) && requiredMap.get(charStart)<0){
                while (requiredMap.get(parentString.charAt(start)) == null || requiredMap.get(parentString.charAt(start))<0){
                    if(requiredMap.containsKey(parentString.charAt(start))) {
                        requiredMap.put(parentString.charAt(start), requiredMap.get(parentString.charAt(start)) + 1);
                    }
                    start++;
                }
            }

            end++;
        }
        if(count == 0 && (minEnd == 0 || end-start+1 < minEnd-maxStart+1)){
            minEnd = end;
            maxStart = start;
        }
        return parentString.substring(maxStart, minEnd);
    }

    static String getMinWindowSubstring2(String parentString, String minRequiredSubstring){
        int start = 0, end = 0;
        HashMap<Character, Integer> requiredMap = new HashMap<>();
        HashMap<Character,Integer> answerMap = new HashMap<>();
        int maxStart = 0, minEnd = 0;
        for(int i=0; i<minRequiredSubstring.length(); i++) {
            char ch = minRequiredSubstring.charAt(i);
            requiredMap.put(ch, requiredMap.getOrDefault(ch, 0)+1);
        }
        int count =requiredMap.size();
        while (end < parentString.length()){
            if(count == 0 && (minEnd ==0 || end-start+1< minEnd-maxStart+1)){
                minEnd = end;
                maxStart = start;
            }
            char charEnd = parentString.charAt(end);
            answerMap.put(charEnd, answerMap.getOrDefault(charEnd,0 )+1);
            if (answerMap.get(charEnd).equals(requiredMap.get(charEnd))){
                count--;
            }
            char charStart = parentString.charAt(start);
            if (requiredMap.get(charStart)==null) {
                answerMap.remove(charStart);
                start++;
            } else {
                while (requiredMap.get(parentString.charAt(start)) == null || requiredMap.get(parentString.charAt(start))< answerMap.get(parentString.charAt(start))){
                    answerMap.put(parentString.charAt(start), answerMap.get(parentString.charAt(start)) - 1);
                    if (answerMap.get(parentString.charAt(start)) == 0) {
                        answerMap.remove(parentString.charAt(start));
                    }
                    start++;
                }
            }
            end++;
        }
        if(count == 0 && (minEnd == 0 || end-start+1 < minEnd-maxStart+1)){
            minEnd = end;
            maxStart = start;
        }
        return parentString.substring(maxStart, minEnd);
    }

    public static String minWindow(String bigSet, String smallSet) {
        if(smallSet.length()>bigSet.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] smallChars = smallSet.toCharArray();
        for(char smallChar : smallChars){
            map.put(smallChar, map.getOrDefault(smallChar, 0)+1);
        }
        HashMap<Character, Integer> rMap = new HashMap<>();
        int rCount = map.size();
        int resultStart = 0, resultEnd = 0;

        boolean change = false;

        int start=0, end=0;
        while(end<bigSet.length()){
            char charEnd = bigSet.charAt(end);
            if(map.containsKey(charEnd)){
                rMap.put(charEnd, rMap.getOrDefault(charEnd, 0)+1);
                if(rMap.get(charEnd)==map.get(charEnd)){
                    rCount--;
                }
            }
            if(rCount == 0){
                while(!map.containsKey(bigSet.charAt(start)) || (map.containsKey(bigSet.charAt(start)) && map.get(bigSet.charAt(start))<rMap.get(bigSet.charAt(start)))) {
                    if(!map.containsKey(bigSet.charAt(start))){

                    } else if(map.get(bigSet.charAt(start))<rMap.get(bigSet.charAt(start))) {
                        rMap.put(bigSet.charAt(start), rMap.get(bigSet.charAt(start)) - 1);
                    }
                    start++;
                }
                if(!change || resultEnd-resultStart>end-start){
                    change = true;
                    resultEnd = end;
                    resultStart = start;
                }
            }
            end++;
        }
        if(!change){
            return "";
        }
        return bigSet.substring(resultStart, resultEnd+1);
    }
}
