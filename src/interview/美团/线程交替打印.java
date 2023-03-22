package interview.美团;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/13/16:12
 * @Description:
 */
public class 线程交替打印 {
    public static volatile boolean flag = true;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        while (true){
             if(flag) {
                Thread A = new Thread(myThread, "A");
                A.start();
                flag = false;
            }
             if(!flag) {
                Thread B = new Thread(myThread, "B");
                B.start();
                flag = true;
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName() + "打印" + Thread.currentThread().getName());
    }
}
