package Arrays.RePractise.SlidingWindow;

//Count Occurrences Of Anagrams | Sliding Window
public class CountOccurenceAnagrams {
    public static void main(String[] args) {
        String parent = "Hiteshwar Mehla";
        String child = "eh";
        System.out.println(getAnagramOccurrenceCount(parent, child));
    }

    static int getAnagramOccurrenceCount(String parent, String child){
        int count = 0;
        if(parent.contentEquals(child)){
            count++;
        }


        return count;
    }
}
