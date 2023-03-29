package solution.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/22:48
 * @Description:
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // 创建2个数量级的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 创建任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行，线程：" + Thread.currentThread().getName());
            }
        };
        executorService.submit(runnable);
        executorService.execute(runnable);
        executorService.submit(runnable);
        executorService.execute(runnable);

    }
}
