package solution.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 21:40
 */
public class VolatileAtomic {
    public static volatile int i = 0;
    AtomicInteger ai=new AtomicInteger();

    public synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileAtomic volatileAtomic = new VolatileAtomic();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomic.increase();
                }
            });
        }
        Thread.sleep(1500);
        System.out.println(i);
        executorService.shutdown();
    }
}
