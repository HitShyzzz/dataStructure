package solution.死锁;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/23/16:55
 * @Description:
 */
public class UnLockTest {
    public static String object1 = "obj1";
    public static String object2 = "obj2";

    public static void main(String[] args) {
        LockC lockc = new LockC();
        LockD lockd = new LockD();
        new Thread(lockd).start();
        new Thread(lockc).start();
    }
}

class LockC extends Thread {
    @Override
    public void run() {
        System.out.println("LockC 开始执行");
        while (true) {
            synchronized (UnLockTest.object1) {
                System.out.println("lockC lock object1");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (UnLockTest.object2) {
                    System.out.println("lockC lock object2");
                    try {
                        sleep(60 * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

class LockD extends Thread {
    @Override
    public void run() {
        System.out.println("LockD 开始执行");
        while (true) {
            synchronized (UnLockTest.object1) {
                System.out.println("LockD lock object1");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (UnLockTest.object2) {
                    System.out.println("LockD lock object2");
                    try {
                        sleep(60 * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}