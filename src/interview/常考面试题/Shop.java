package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/15:42
 * @Description:
 */
public class Shop {
    public int num = 0;// 资源个数

    // 生产资源
    public synchronized void produceResource() {
        if (num < 10) {
            num++;
            System.out.println(Thread.currentThread().getName() + "正在生产第" + num + "个资源");
            notify();// 唤醒消费者线程
        } else {
            try {
                wait();// 阻塞生产者线程
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 消费资源
    public synchronized void consumeResource() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "正在消费第" + num + "个资源");
            num--;
            notify();// 唤醒生产者线程
        } else {
            try {
                wait();// 阻塞消费者线程
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
