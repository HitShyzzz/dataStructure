package interview.京东;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/02/8:09
 * @Description:
 */
public class JoinTest {
    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThead();
        Thread t2 = new MyThead();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // 此时i的值是无法确定的！
        System.out.println(i);
    }

    static class MyThead extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }

        public synchronized void add() {
            i++;
        }
    }
}
