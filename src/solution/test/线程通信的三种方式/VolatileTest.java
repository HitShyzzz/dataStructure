package solution.test.线程通信的三种方式;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/09/8:56
 * @Description:
 */
public class VolatileTest {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (flag) {
                        System.out.println("线程A");
                        flag = false;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (!flag) {
                        System.out.println("线程B");
                        flag = true;
                    }
                }
            }
        }).start();
    }

}
