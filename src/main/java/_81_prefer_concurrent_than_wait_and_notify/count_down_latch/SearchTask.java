package _81_prefer_concurrent_than_wait_and_notify.count_down_latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
    private int id;
    private CountDownLatch latch;

    public SearchTask(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("开始寻找第" + id + "颗龙珠");
        int seconds = new Random().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("花了" + seconds + "秒，找到了" + id + "号龙珠");
    }
}
