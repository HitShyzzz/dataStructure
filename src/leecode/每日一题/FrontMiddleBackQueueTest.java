package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-28 20:56
 */
public class FrontMiddleBackQueueTest {
    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue = new FrontMiddleBackQueue();
        frontMiddleBackQueue.pushFront(1);
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.pushBack(2);
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.pushMiddle(3);
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.pushMiddle(4);
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.popFront();
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.popMiddle();
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.popMiddle();
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.popBack();
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
        frontMiddleBackQueue.popFront();
        for (Integer i : frontMiddleBackQueue.list) {
            System.out.print(i + " ");
        }
        System.out.println("--------------");
    }
}
