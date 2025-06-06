package EPAMCoding.Trie;

import java.util.List;

public class dictionaryLexicographically {
    public static void main(String[] args) {
        String letters = "oet";
        List<String> dict = List.of("abc","oet", "to", "toe","toes");
        String result = getlongestPossibleWordInDictionary(letters, dict);
        System.out.println(result);
    }

    //O(L*N)
    static String getlongestPossibleWordInDictionary(String letters, List<String> dict) {
        int maxLen = Integer.MIN_VALUE;
        String result = null;
        for(String word:dict){
            TrieImplementation.insertInTrie(word);
        }
        for (String word:dict) {
            if(word.length()==letters.length() && TrieImplementation.searchInTrie(letters)){
                int getLen = word.length();
                if(getLen >= maxLen ) {
                    result = word;
                }
            }
        }
        return result;
    }
}
