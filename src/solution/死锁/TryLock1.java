package solution.死锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/30/8:57
 * @Description:
 */
public class TryLock1 {
    Lock lock = new ReentrantLock();
   // ReadWriteLock

    /**
     * @param args
     */
    public static void main(String[] args) {
        //实例化本类对象，目的是调用runThread方法
        TryLock1 tl = new TryLock1();
        //匿名对象创建线程1，并重写run方法，启动线程
        new Thread() {
            public void run() {

                tl.runThread(Thread.currentThread());
            }
        }.start();
        //匿名对象创建线程2，并重写run方法，启动线程
        new Thread() {
            public void run() {

                tl.runThread(Thread.currentThread());
            }
        }.start();


    }

    //线程共同调用方法
    public void runThread(Thread t) {
        //lock对象调用trylock(long time , TimeUnit unit)方法尝试获取锁
        try {
            //注意，这个方法需要抛出中断异常
            if (lock.tryLock(2000L, TimeUnit.MILLISECONDS)) {
                //获锁成功代码段
                System.out.println("线程" + t.getName() + "获取锁成功");
                try {
                    //执行的代码
                    Thread.sleep(3000);
                } catch (Exception e) {
                    //异常处理内容，比如中断异常
                } finally {
                    //获取锁成功之后，一定记住加finally并unlock()方法,释放锁
                    System.out.println("线程" + t.getName() + "释放锁");
                    lock.unlock();
                }
            } else {
                //获锁失败代码段
                //具体获取锁失败的回复响应
                System.out.println("线程" + t.getName() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
