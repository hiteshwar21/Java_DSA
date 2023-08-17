package Strings;

import java.util.HashMap;

/*John is at a toy store help him pick maximum number of toys.
He can only select in a continuous manner, and he can select only two types of toys.
        Example:
        Input:
        1
        abaccab
        Output:
        4 */
public class pickToysWithKUniqueElements {
    public static void main(String[] args) {
        String parent = "abaccab";
        int uniqueCount = 2;
        System.out.println(getMaxToysInSequence(parent, uniqueCount));
    }

    static int getMaxToysInSequence(String parent, int uniqueCount){
        int start = 0, end = 0;
        int maxCount = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (end<parent.length()){
            char charEnd = parent.charAt(end);
            hashMap.put(charEnd, hashMap.getOrDefault(charEnd,0)+1);
            if (hashMap.size() == uniqueCount){
                maxCount = Math.max(maxCount, end-start+1);
            }
            while (hashMap.size() > uniqueCount){
                char charStart = parent.charAt(start);
                hashMap.put(charStart, hashMap.get(charStart)-1);
                if(hashMap.get(charStart) == 0){
                    hashMap.remove(charStart);
                }
                start++;
            }
            end++;
        }
        return maxCount;
    }

}
