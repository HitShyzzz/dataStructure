package interview.美团.多线程生产者消费者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/14/0:03
 * @Description:
 */
public class Consumer extends Thread {
    private Shop shop;
    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费面包.....");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.consumeBread();
        }
    }
}
