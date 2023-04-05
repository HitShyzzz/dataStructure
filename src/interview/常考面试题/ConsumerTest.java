package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/15:52
 * @Description:
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Producer producer = new Producer(shop);
        producer.setName("生产者线程");
        Consumer consumer = new Consumer(shop);
        consumer.setName("消费者线程");
        producer.start();
        consumer.start();
    }
}
