package leecode.排序;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/01/12:09
 * @Description:
 */
public class 单链表排序 {
    /**
     * 堆排序，先把链表元素加入小根堆中，然后一一取出，连接成链表就好了，但要记得把链表的最后的尾巴截断，
     * O(T)=O(nlogn);
     * O(S)=O(n);
     *
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            heap.offer(head);
            head = head.next;
        }
        ListNode newHead = null;
        ListNode tail = newHead;
        while (!heap.isEmpty()) {
            if (newHead == null) {
                newHead = tail = heap.poll();
            } else {
                tail.next = heap.poll();
                tail = tail.next;
            }
        }
        // 要把链表的尾巴截断
        tail.next = null;
        return newHead;
    }
}
