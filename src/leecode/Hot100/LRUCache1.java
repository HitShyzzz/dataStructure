package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 双向链表+哈希Map实现
 * @date: 2024-06-18 21:13
 */
public class LRUCache1 {
    private int capacity;
    // 虚拟头部
    private DNode head;
    // 虚拟尾部
    private DNode tail;
    private Map<Integer, DNode> map;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(DNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    // 添加到尾部，
    public void addToTail(DNode node) {
        // 这几步较难写出，重点理解
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }

    // 移动到尾部，相当于先删除node，再把node添加到尾部
    public void moveToTail(DNode node) {
        deleteNode(node);
        addToTail(node);
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        moveToTail(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        DNode node = new DNode(key, value);
        // 如果包含了该元素，就要该key对应的value赋值成value，并把该结点移动到尾部
        if (map.containsKey(key)) {
            map.get(key).value = value;
            moveToTail(map.get(key));
        } else {// 不包含就要先放入map，再添加到尾部
            // map如果满了就要删除头部元素
            if (map.size() == capacity) {
                DNode dNode = head.next;
                deleteNode(dNode);
                map.remove(dNode.key);
            }
            map.put(key, node);
            addToTail(node);
        }
    }

}

// 双向链表
class DNode {
    public DNode next;
    public DNode prev;
    public int key;
    public int value;

    public DNode() {
    }

    public DNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
