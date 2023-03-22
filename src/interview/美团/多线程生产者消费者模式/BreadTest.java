package interview.美团.多线程生产者消费者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/14/0:04
 * @Description:
 */
public class BreadTest {
    public static void main(String[] args) {
        // 创建商店对象
        Shop shop = new Shop();
        // 创建生产者对象，把商店对象作为构造方法参数传入生产者对象中
        Producer p1 = new Producer(shop);
        p1.setName("生产者");
        // 创建消费者对象，把商店对象作为构造方法参数传入消费者对象中
        Consumer c1 = new Consumer(shop);
        c1.setName("消费者");
        p1.start();
        c1.start();

    }
}
