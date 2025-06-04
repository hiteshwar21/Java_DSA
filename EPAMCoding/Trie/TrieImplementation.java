package EPAMCoding.Trie;

public class TrieImplementation {
    static class Node {
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            eow=false;
        }
    }

    static Node root = new Node();

    //Time O(N) - N -> length of word
    static boolean searchInTrie(String word){
        Node node = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) -'a';
            // if children not found, then return false
            if(node.children[idx] == null) {
                return false;
            } else {
                // if we have reached the end of our current word, then check if eow is true or not
                if(i == word.length()-1 && !node.children[idx].eow){
                    return false;
                }
            }
            node = node.children[idx];
        }
        return true;
    }

    //Time O(N) - N -> length of word
    static void insertInTrie(String word){
        Node node =root;
        for(int i=0; i<word.length();i++){
            int idx = word.charAt(i) -'a';
            //checking if the value is existing or not
            if(node.children[idx] == null) {
                //adding new Node
                node.children[idx] = new Node();
            }
            //checking if it is the end of word
            if(i==word.length()-1){
                node.children[idx].eow = true;
            }
            node = node.children[idx];
        }
    }

    public static void main(String[] args) {
        String[] words = {"the", "a", "their", "there", "any"};
        //Insert in TRIE
        for(String word:words) {
            insertInTrie(word);
        }
        // Search in TRIE
        System.out.println(searchInTrie("the"));
        System.out.println(searchInTrie("th"));
        System.out.println(searchInTrie("that"));
    }
}
