package Trie;

/*Given an input string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of dictionary words.
        words[ ] = (i, like, sam, samsung, mobile, ice)
        key = "ilikesamsung"*/
public class wordBreakProblem {
    public static void main(String[] args) {
        String[] words = {"i","like", "sam", "samsung", "mobile", "ice"};
        for(int i=0;i<words.length;i++){
            TrieImpl.insertInTrie(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(findWordBreaker(key));
    }

    static boolean findWordBreaker(String key){
        if (key.length() == 0){
            return true;
        }
        for (int i =1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(TrieImpl.searchInTrie(firstPart) && findWordBreaker(secondPart)){
                return true;
            }
        }
        return false;
    }
}
