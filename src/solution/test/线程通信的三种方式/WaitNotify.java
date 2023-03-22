package solution.test.线程通信的三种方式;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/09/9:13
 * @Description:
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitThread(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new NotifyThread(), "NotifyThread");
        notifyThread.start();
    }

    //等待线程
    static class WaitThread implements Runnable {
        public void run() {
            //加锁
            synchronized (lock) {
                //条件不满足时，继续等待，同时释放lock锁
                while (flag) {
                    System.out.println("flag为true，不满足条件，继续等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足
                System.out.println("flag为false，我要从wait状态返回继续执行了");

            }

        }
    }

    //通知线程
    static class NotifyThread implements Runnable {

        public void run() {
            //加锁
            synchronized (lock) {
                //获取lock锁，然后进行通知，但不会立即释放lock锁，需要该线程执行完毕
                lock.notifyAll();
                System.out.println("设置flag为false,我发出通知了，但是我不会立马释放锁");
                flag = false;
            }
        }
    }
}

