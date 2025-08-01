package EPAMCoding;

import java.util.HashMap;
import java.util.Map;

/*Example:
Suppose n = 6, timestamps = [1, 4, 5, 10, 11, 14], messages = ["hello", "bye", "bye", "hello", "bye", "hello"], and k = 5.

Timestamps Message Delivered
1 Hello true
4 Bye true
5 Bye false
10 Hello true
11 Bye true
14 Hello false*/
public class RateLimiter101 {
    public static void main(String[] args) {
        //int n = 6;
        int[] timestamps = {1, 4, 5, 10, 11, 14};
        String[] messages = {"hello", "bye", "bye", "hello", "bye", "hello"};
        int k = 5;
        getMessageStatus(timestamps, messages, k);
    }

    private static void getMessageStatus(int[] timestamps, String[] messages, int timeLimiter){
        Map<String, Integer> freqMap = new HashMap<>();
        for(int i=0; i<messages.length; i++) {
            if(freqMap.containsKey(messages[i])) {
                int prevValue = freqMap.get(messages[i]);
                int currValue = timestamps[i];
                if(currValue - prevValue > timeLimiter) {
                    System.out.println(timestamps[i] + " " + messages[i] + " true");
                } else {
                    System.out.println(timestamps[i] + " " + messages[i] + " false");
                }
            } else {
                System.out.println(timestamps[i] + " " + messages[i] + " true");
            }
            freqMap.put(messages[i], timestamps[i]);
        }
    }
}
