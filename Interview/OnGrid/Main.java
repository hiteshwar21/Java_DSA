package Interview.OnGrid;
/*
You are tasked with designing a multithreaded program in Java that maintains a counter. The program has three components:

        1. Counter Class:
        The Counter class must provide methods to increment and retrieve the counter value.
        It should be thread-safe and handle concurrent access from multiple threads.

        2. Incrementer Thread:
        There are multiple threads that aim to increment the counter simultaneously.
        Each thread increments the counter a random number of times (between 1 and 10, inclusive).

        3. Checker Thread:
        A separate thread continuously checks the counter value and logs a message if the counter exceeds a certain threshold (e.g., 100).

        Your solution should address the following aspects:

        A. Counter class ensuring thread safety using appropriate synchronization mechanisms.
        B. Prevent race conditions that might occur when multiple threads attempt to access and update the counter concurrently.
        C. Design a strategy to test for edge cases (like hitting the counter's upper limit, thread coordination, etc.).
        D. Optimize the code structure to minimize unnecessary locking or contention.
        E. Handle any exceptions or potential deadlock scenarios gracefully.*/

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CheckerThread checkerThread = new CheckerThread(counter, 100);
        checkerThread.setDaemon(true); // Daemon thread to stop with the main program

        checkerThread.start();

        for (int i = 0; i < 5; i++) {
            new IncrementerThread(counter).start();
        }
    }
}


/*
    CheckerThread checkThread = new CheckerThread();
    checkThread.setExceedNumber(100);

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}

//Singleton Class
//Observer - observable - notifyObserver(Object);
    class Counter{
        // private default constructor
        // static
        // synchronised
        private Counter(){
            //default constrcutor
        }

        private static int count = 0;
        private static Counter INSTANCE;

        private synchronized static getInstance(){
            if(INSTANCE == null){
                INSTANCE = new Counter();
            }
            return INSTANCE;
        }

        public int getCount(int threadExtender) {
            count+= threadExtender;
            //if(count>100){
            //    notifyObserver(count);
            //}
            return count;
        }

        public int getCount() {
            return count;
        }
    }
    //checker - counter, threshold
    class IncrementThread extends Thread {
        //Math.random()%10 + 1
        Thread thread = new Thread();
    thread.run() -> {
            public int getIncrementCount(){
                int random = Math.getRandom();
                return random%10+1;
            }
        }
    }

    class CheckerThread extends Thread {
        private static int exceedNumber;

        public void setExceedNumber(int number) {
            exceedNumber = number;
        }

        public void checkThreadCount(){
            incrementalCount = Counter.getCount();
            if(incrementalCount > ExceedNumber){
                System.out.println("Count has gone beyond : " + exceedNumber + " and current number is : " + incrementalCount);
            }
        }
    }

    public static void main(strings[] args) {
        Counter singleton = Counter.getInstance();
        IncrementThread incrementCounter = new IncrementThread();

        CheckerThread checkThread = new CheckerThread();
        checkThread.setExceedNumber(100);
        int loopCount = 100;
        //should be run for different threads
        for(int i = 0; i<loopCount; i++) {
            int currentIncrementCount = incrementalCounter.getIncrementCount();
            singleton.getCount(currentIncrementCount);
        }
    }
}
*/