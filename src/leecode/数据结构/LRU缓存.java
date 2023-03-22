package leecode.数据结构;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/08/20:08
 * @Description:
 */
public class LRU缓存 {

}

/**
 * // 要使用LinkedHashMap按照访问的顺序进行put操作！
 * // LinkedHashMap就是专门来写LRU的呀！
 * class LRUCache extends LinkedHashMap<Integer, Integer> {
 * int capacity;
 * <p>
 * public LRUCache(int capacity) {
 * // 参数1初始容量，参数2装载因子，参数3是排列顺序，true按照访问顺序进行排列，false按照插入顺序进行排列！
 * super(capacity,0.75F,true);
 * this.capacity = capacity;
 * }
 * <p>
 * public int get(int key) {
 * return super.getOrDefault(key, -1);
 * }
 * <p>
 * public void put(int key, int value) {
 * super.put(key, value);
 * }
 *
 * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 * return super.size() > capacity;
 * }
 * }
 */
// 下面手写LinkedHashMap的get,put,方法

/**
 * LinkedHashMap是用哈希表和双向链表实现的；
 */
class LRUCache {
    // 链表结点，每个结点存的是map的一个实体，也就是一个键值对！
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;// 前驱结点
        LinkedNode next;// 后继结点

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, LinkedNode> map = new HashMap<>();
    LinkedNode head;
    LinkedNode tail;
    int size;// 当前容量
    int capacity;// 初始容量

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 亚结点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode cache = map.get(key);
        if (cache == null) {
            return -1;
        }
        // 如果存在，则先要把当前结点移动到链表头部，再返回cache.value;
        moveToHead(cache);
        return cache.value;

    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        // 如果这个key不存在，则要创建新的结点并加入到头部
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            map.put(key, newNode);
            // 添加到头部
            addToHead(newNode);
            size++;
            // 如果容量超了，则还要移除链表尾部元素
            if (size > capacity) {
                LinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {// 如果这个key存在，则要把value改成新的value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;// 从左到右删除
        node.next.prev = node.prev;// 从右到左删除
    }

    private void addToHead(LinkedNode node) {
        // 前面有个亚结点，别忘了
        node.prev = head;
        node.next = head.next;
        // 从右向左加
        head.next.prev = node;
        head.next = node;
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.prev;// 尾部有个亚结点，真正要删除的是亚结点前面的那个结点
        removeNode(node);// 把node结点嘎掉！
        return node;
    }

}
