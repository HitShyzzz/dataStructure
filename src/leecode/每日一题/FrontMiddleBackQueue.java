package leecode.每日一题;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-28 20:21
 */
public class FrontMiddleBackQueue {

    private int rear;
    public List<Integer> list;
    private int size;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
        size = 0;
        rear = 0;
    }

    public void pushFront(int val) {
        if (list.isEmpty()) {
            list.add(val);
            rear = 0;
            size++;
            return;
        }
        list.add(0, val);
        size++;
        rear = size - 1;
    }

    public void pushMiddle(int val) {
        int index = size / 2;
        list.add(index, val);
        size++;
        rear = size - 1;
    }

    public void pushBack(int val) {
        list.add(val);
        size++;
        rear = size - 1;
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        int remove = list.remove(0);
        size--;
        rear = (size > 0 ? -1 : 0) + size;
        return remove;
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        int mid = (size % 2 == 0 ? -1 : 0) + size / 2;
        int remove = list.remove(mid);
        size--;
        rear = (size > 0 ? -1 : 0) + size;
        return remove;
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        int remove = list.remove(rear);
        size--;
        rear = (size > 0 ? -1 : 0) + size;
        return remove;
    }
}
