package leecode.Hot100;

import java.util.PriorityQueue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 用小根堆来存放链表元素，O(T)=O(nlogn)，O(S)=O(n)，
 * 不符合题目要求的常数级空间复杂度
 * @date: 2024-06-18 20:17
 */
public class 排序链表 {
    // 输入：head = [4,2,1,3]
    // 输出：[1,2,3,4]
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode cur = head;
        while (cur != null) {
            pq.offer(cur);
            cur = cur.next;
        }
        ListNode newHead = pq.peek();
        cur = newHead;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}
