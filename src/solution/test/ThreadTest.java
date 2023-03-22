package solution.test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/22:47
 * @Description:
 */
public class ThreadTest implements Runnable{

    public void run(){

        synchronized(this){
            for(int i=0;i<10;i++){
                System.out.print(" " + i);
            }
        }
    }

    public static void main(String[] args){
        Runnable r = new ThreadTest();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}
