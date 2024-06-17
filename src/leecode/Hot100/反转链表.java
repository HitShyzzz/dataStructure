package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 20:28
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
}
