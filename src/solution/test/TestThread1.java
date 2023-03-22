package solution.test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/07/20:32
 * @Description:
 */
public class TestThread1 {
    public static void main(String[] args) throws Exception {
        testImplents();
    }

    public static void testImplents() throws Exception {
        MyThreadImplements myThreadImplements = new MyThreadImplements();
        Thread t1 = new Thread(myThreadImplements);
        Thread t2 = new Thread(myThreadImplements, "my thread -2");
        t1.start();
        t2.start();
    }
}

//线程类
class MyThreadImplements implements Runnable {
    @Override
    public void run() {
        System.out.println("通过实现Runable，线程号:" + Thread.currentThread().getName());
    }
}

