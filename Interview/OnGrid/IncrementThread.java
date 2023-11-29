package Interview.OnGrid;

import java.util.Random;

class IncrementerThread extends Thread {
    private final Counter counter;
    private final Random random = new Random();

    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int timesToIncrement = random.nextInt(10) + 1;
        for (int i = 0; i < timesToIncrement; i++) {
            counter.increment();
            System.out.println(Thread.currentThread().getName() + " incremented the counter. New value: " + counter.getValue());
        }
    }
}