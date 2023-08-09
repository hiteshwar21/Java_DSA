package Trie;

//Find the longest string in words such that every prefix of it is also in words
public class LongestWordWithAllPrefix {

    static class Node {
        Node[] children;  //26
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    static void insertInTrie(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                node.children[idx].eow = true;
            }
            node = node.children[idx];
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "ap", "app", "appl", "apple", "apply"};
        for (int i = 0; i < words.length; i++) {
            insertInTrie(words[i]);
        }
        getLongestWithAllPrefixes(root, new StringBuilder(""));
        System.out.println(ans);
    }

    public static String ans = "";

    public static void getLongestWithAllPrefixes(Node root, StringBuilder curr) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                curr.append((char) (i + 'a'));
                if (curr.length() > ans.length()) {
                    ans = curr.toString();
                }
                getLongestWithAllPrefixes(root.children[i], curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}

