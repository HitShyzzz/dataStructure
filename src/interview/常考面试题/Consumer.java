package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/04/15:50
 * @Description:
 */
public class Consumer extends Thread{
    private Shop shop;
    public Consumer(Shop shop){
        this.shop=shop;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费资源");
        while (true){
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.consumeResource();
        }
    }
}
