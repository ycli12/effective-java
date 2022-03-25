package _81_prefer_concurrent_than_wait_and_notify.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        // 例子：用7个线程帮助我们收集7颗龙珠，收集的时间是不确定的，因此我们需要等待全部收集完成
        int[] ids = {1, 2, 3, 4, 5, 6, 7};
        CountDownLatch latch = new CountDownLatch(ids.length);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int id : ids) {
            executorService.submit(new SearchTask(id, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("找到7颗龙珠，召唤神龙！");
        executorService.shutdown();
    }
}
