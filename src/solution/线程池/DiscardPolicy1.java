package solution.线程池;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/29/23:29
 * @Description:
 */
public class DiscardPolicy1 {
    public static void main(String[] args) {
        // 任务的具体方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前任务被执行,执行时间:" + new Date() +
                        " 执行线程:" + Thread.currentThread().getName());
                try {
                    // 等待 1s
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 创建线程,线程的任务队列的长度为 1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());
        // 添加并执行 4 个任务
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
    }
}
