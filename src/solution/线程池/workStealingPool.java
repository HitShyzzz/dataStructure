package solution.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/23:12
 * @Description:
 */
public class workStealingPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + "被执行，线程名：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        while (!threadPool.isTerminated()) {

        }
    }
}
