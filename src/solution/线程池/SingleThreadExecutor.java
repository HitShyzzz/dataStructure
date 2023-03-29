package solution.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/23:07
 * @Description:
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            threadPool.execute(task);
        }
    }
}
