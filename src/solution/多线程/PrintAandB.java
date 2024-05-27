package solution.多线程;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-04 21:38
 */
public class PrintAandB {
    public static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();

    }
}

class A implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (PrintAandB.obj) {
                System.out.println("A");
                PrintAandB.obj.notifyAll();
                try {
                    PrintAandB.obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class B implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (PrintAandB.obj) {
                System.out.println("B");
                PrintAandB.obj.notifyAll();
                try {
                    PrintAandB.obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}