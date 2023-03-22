package interview.美团.多线程生产者消费者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/23:54
 * @Description:
 */
public class Producer extends Thread{
    private Shop shop;
    public Producer (Shop shop){
        this.shop=shop;
    }
    @Override
    public void run() {
        System.out.println(getName() + ":开始生产面包.....");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.produceBread();
        }
    }
}
