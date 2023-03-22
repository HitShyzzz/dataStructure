package solution.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/07/20:36
 * @Description:
 */
public class TestThread2 {
    public static void main(String[] args) throws Exception {
        testCallable();
    }

    public static void testCallable() throws Exception {
        Callable callable = new MyThreadCallable();
        FutureTask task = new FutureTask(callable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
        Thread.sleep(10);//等待线程执行结束
        //task.get() 获取call()的返回值。若调用时call()方法未返回，则阻塞线程等待返回值
        //get的传入参数为等待时间，超时抛出超时异常；传入参数为空时，则不设超时，一直等待
        System.out.println(task.get(100L, TimeUnit.MILLISECONDS));
    }
}

class MyThreadCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("通过实现Callable，线程号:" + Thread.currentThread().getName());
        return 10;
    }
}