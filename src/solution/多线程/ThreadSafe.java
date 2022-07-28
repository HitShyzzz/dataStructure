package solution.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/11:35
 * @Description:
 */
public class ThreadSafe extends Thread {
    public static void main(String[] args) {
        ThreadSafe threadSafe=new ThreadSafe();
        threadSafe.setDaemon(true);

        ThreadSafe safe=new ThreadSafe();
        safe.run1();
    }
    public synchronized void run1() {
        //ReentrantLock
        while (!isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
            try{
                Thread.sleep(5*1000);//阻塞过程捕获中断异常来退出
            }catch(InterruptedException e){
                e.printStackTrace();
                break;//捕获到异常之后，执行 break 跳出循环
            }
        }
    }
}
