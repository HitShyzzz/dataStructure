package solution.死锁;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/23/11:59
 * @Description:
 */
public class LockTest {
    public static String object1 = "obj1";
    public static String object2 = "obj2";

    public static void main(String[] args) {
        LockA lockA = new LockA();
        lockA.start();
        LockB lockB = new LockB();
        lockB.start();
    }
}

class LockA extends Thread {
    @Override
    public void run() {
        System.out.println("LockA 开始执行");
        while (true) {
            synchronized (LockTest.object1) {
                System.out.println("lockA lock object1");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LockTest.object2) {
                    System.out.println("lockA lock object2");
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

class LockB extends Thread {
    @Override
    public void run() {
        System.out.println("LockB 开始执行");
        while (true) {
            synchronized (LockTest.object2) {
                System.out.println("LockB lock object2");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LockTest.object1) {
                    System.out.println("LockB lock object1");
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
