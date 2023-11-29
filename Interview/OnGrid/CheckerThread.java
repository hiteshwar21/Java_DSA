package Interview.OnGrid;

public class CheckerThread extends Thread {
    private final Counter counter;
    private final int threshold;

    public CheckerThread(Counter counter, int threshold) {
        this.counter = counter;
        this.threshold = threshold;
    }

    @Override
    public void run() {
        while (true) {
            int value = counter.getValue();
            if (value > threshold) {
                System.out.println("Counter value exceeds threshold. Value: " + value);
            }
            try {
                Thread.sleep(100); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}