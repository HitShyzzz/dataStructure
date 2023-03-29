package solution.线程池;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/23:01
 * @Description:
 */
public class SingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService threadpool = Executors.newSingleThreadScheduledExecutor();
        System.out.println("任务开始时间：" + new Date());
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行时间：" + new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        threadpool.schedule(task, 2, TimeUnit.SECONDS);
    }
}
