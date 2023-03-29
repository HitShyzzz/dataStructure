package interview.常考面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/27/8:09
 * @Description:
 */
public class LRUCache {
    Dnode head;// 虚拟的头
    Dnode tail;// 虚拟的尾
    int capacity;
    Map<Integer, Dnode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Dnode(0, 0);
        tail = new Dnode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(Dnode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addToTail(Dnode node) {
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }

    public void moveToTail(Dnode node) {
        deleteNode(node);
        addToTail(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Dnode node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Dnode node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            // 缓存满了
            if (map.size() == capacity) {
                // 要删除的结点
                Dnode node = head.next;
                deleteNode(node);
                map.remove(node.key);
            }
            Dnode newNode = new Dnode(key, value);
            addToTail(newNode);
            map.put(key, newNode);
        }
    }

}

class Dnode {
    Dnode prev;
    Dnode next;
    int key;
    int value;

    public Dnode() {

    }

    public Dnode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
