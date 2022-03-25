package _81_prefer_concurrent_than_wait_and_notify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(time(Executors.newCachedThreadPool(), 3, () -> System.out.println("哈哈哈哈...")));
        System.out.println(time(Executors.newCachedThreadPool(), 3, () -> {}));
        System.out.println(time(Executors.newCachedThreadPool(), 30, () -> {}));
    }

    // Simple framework for timing concurrent execution
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();
                // Tell timer we're ready
                try {
                    start.await();
                    // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                    // Tell timer we're done
                }
            });
        }
        ready.await();
        // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown();
        // And they're off!
        done.await();
        // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}