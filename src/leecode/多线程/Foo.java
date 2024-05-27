package leecode.多线程;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-05 21:43
 */
public class Foo {

    private volatile int flag = 1;
    public Object obj = new Object();


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
            while (flag != 1) {
                obj.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            obj.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
            while (flag != 2) {
                obj.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            obj.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
            while (flag != 3) {
                obj.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            obj.notifyAll();
        }
    }
}

