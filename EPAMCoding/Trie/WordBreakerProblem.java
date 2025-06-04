package EPAMCoding.Trie;


/*Given an input string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of dictionary words.
        words[ ] = (i, like, sam, samsung, mobile, ice)
        key = "ilikesamsung"*/
public class WordBreakerProblem {
    public static void main(String[] args) {
        String[] words = {"i","like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        String key2 = "ihatesamsung";
        for(String word: words){
            TrieImplementation.insertInTrie(word);
        }
        System.out.println(findWordBreaker(key));
        System.out.println(findWordBreaker(key2));
    }

    static boolean findWordBreaker(String key){
        //Base Condition
        if(key.length() == 0){
            return true;
        }
        //Logic Part
        for (int i=1;i<=key.length();i++) {
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(TrieImplementation.searchInTrie(firstPart) && findWordBreaker(secondPart)){
                return true;
            }
        }
        return false;
    }
}
