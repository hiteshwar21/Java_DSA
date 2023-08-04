package Strings;

import java.util.HashMap;
import java.util.HashSet;

//Given two strings. The task is to check whether the given strings are anagrams of each other or not.
/*Input: str1 = “listen”  str2 = “silent”
        Output: “Anagram”
        Explanation: All characters of “listen” and “silent” are the same.*/
public class checkAnagram2Strings {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(checkAnagram(str1, str2));
    }

    static boolean checkAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap();
        for(int i =0;i< s1.length();i++){
            hashMap.put(s1.charAt(i), hashMap.getOrDefault(hashMap.get(s1.charAt(i)), 0)+1);
        }

        for (int j = 0;j<s2.length();j++){
            if(hashMap.containsKey(s2.charAt(j)) && hashMap.get(s2.charAt(j))>0){
                hashMap.put(s2.charAt(j), hashMap.get(s2.charAt(j)-1));
            } else {
                return false;
            }
        }
        return true;
    }
}
