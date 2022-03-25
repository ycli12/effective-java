package _81_prefer_concurrent_than_wait_and_notify.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int numOfPerson = 10;
        CyclicBarrier barrier = new CyclicBarrier(numOfPerson, () -> System.out.println("所有人完成等待，准备吃饭"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < numOfPerson; i++) {
            executorService.submit(new Person(barrier));
        }
        executorService.shutdown();
    }
}
