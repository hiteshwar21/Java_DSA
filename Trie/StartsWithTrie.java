package Trie;


public class StartsWithTrie {
    public static void main(String[] args) {
        String[] words = {"apple", "mango", "app", "man", "woman"};
        String key1 = "app";
        String key2 = "moon";
        for (int i=0;i<words.length;i++){
            TrieImpl.insertInTrie(words[i]);
        }
        System.out.println(checkStartsWith(key1));
        System.out.println(checkStartsWith(key2));
    }

    static boolean checkStartsWith(String key){
        TrieImpl.Node node = TrieImpl.root;
        for (int i=0;i< key.length();i++){
            int idx = key.charAt(i) - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}
