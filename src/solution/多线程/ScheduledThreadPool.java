package solution.多线程;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/11:06
 * @Description:
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(() -> System.out.println("延迟三秒"),3,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("延迟 1 秒后每三秒执行一次"),1,3,TimeUnit.SECONDS);
    }
}
