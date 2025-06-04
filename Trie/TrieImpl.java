package Trie;

public class TrieImpl {

    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void main(String[] args) {
        String[] words = {"the", "a", "their", "there", "any"};
        //Insert in TRIE
        for (String word:words) {
            insertInTrie(word); // Time Complexity - O(words.length())
        }
        // Search in TRIE
        System.out.println(searchInTrie("the"));
        System.out.println(searchInTrie("that"));
    }

    static void insertInTrie(String word){
        Node node = root;
        for(int i=0;i< word.length();i++){
            int idx = word.charAt(i) - 'a';

            if(node.children[idx] == null){
                //adding new Node
                node.children[idx] = new Node();
            }
            if(i== word.length()-1){
                node.children[idx].eow = true;
            }
            node = node.children[idx];
        }
    }

    static boolean searchInTrie(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null){
                return false;
            } else {
                if (i == word.length() - 1 && !node.children[idx].eow) {
                    return false;
                }
            }
            node = node.children[idx];
        }
        return true;
    }
}
