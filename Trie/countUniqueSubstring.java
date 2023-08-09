package Trie;

/*str = "ababa"
ans = 10 because possible combo - "" , a, b, ab, ba, aba, bab, abab, baba, ababa*/
public class countUniqueSubstring {
    public static void main(String[] args) {
        String word = "ababa";
        System.out.println(getUniqueSubstring(word));
    }

    static int getUniqueSubstring(String word){
        for(int i=0;i<word.length();i++){
            TrieImpl.insertInTrie(word.substring(i));
        }
        TrieImpl.Node node = TrieImpl.root;
        return getCount(node);
    }

    static int getCount(TrieImpl.Node node){
        if(node == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                count += getCount(node.children[i]);
            }
        }
        return count+1;
    }
}
