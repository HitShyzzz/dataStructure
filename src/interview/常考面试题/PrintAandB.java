package interview.常考面试题;


/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 23:35
 */
public class PrintAandB {
    public static void main(String[] args) {
        PrintAandB obj = new PrintAandB();
        PrintA printA = new PrintA(obj);
        PrintB printB = new PrintB(obj);
        new Thread(printA).start();
        new Thread(printB).start();
    }


}

class PrintA implements Runnable {
    PrintAandB obj;

    public PrintA(PrintAandB obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                System.out.println("A");
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class PrintB implements Runnable {
    PrintAandB obj;

    public PrintB(PrintAandB obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                System.out.println("B");
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
