package Interview.OnGrid;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int value;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    /*
    ExecutorService executorService = Executors.newFixedThreadPool(5);

// Submit a Runnable task
executorService.submit(() -> System.out.println("Executing Runnable"));

// Submit a Callable task and retrieve the result using Future
Future<String> future = executorService.submit(() -> {
    System.out.println("Executing Callable");
    return "Result";
});

try {
    String result = future.get();
    System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

// Shutdown the executor service
executorService.shutdown();

Common implementations of ExecutorService include:
ThreadPoolExecutor: A versatile and customizable implementation.
ScheduledThreadPoolExecutor: Extends ThreadPoolExecutor to support task scheduling.
Executors.newFixedThreadPool(int n): Creates a fixed-size thread pool.
Executors.newCachedThreadPool(): Creates a dynamically sized thread pool.
Executors.newSingleThreadExecutor(): Creates a single-threaded executor.
     */
}