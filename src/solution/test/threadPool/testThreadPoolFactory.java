package solution.test.threadPool;

import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/15/9:43
 * @Description:
 */
public class testThreadPoolFactory implements ThreadFactory{
    private String ThreadPoolName;
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
    public testThreadPoolFactory(String ThreadPoolName){
        this.ThreadPoolName=ThreadPoolName;
    }

}
