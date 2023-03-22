package solution.test.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/15/9:39
 * @Description:
 */
public class cacheThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new testThreadPoolFactory("cachedThread"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                       // print("cachedThreadPool");
                        System.out.println(Thread.currentThread().getName());
                    }
            );
        }
    }
}
