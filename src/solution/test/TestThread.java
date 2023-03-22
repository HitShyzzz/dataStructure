package solution.test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/07/20:26
 * @Description:
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
        testExtends();
    }

    public static void testExtends() throws Exception {
        Thread t1 = new MyThreadExtends();
        Thread t2 = new MyThreadExtends();
        t1.start();
        t2.start();
    }
}

class MyThreadExtends extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread，线程号:" + currentThread().getName());
    }
}
