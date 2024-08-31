package leecode.top50;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-29 20:25
 */
public class 删除链表的倒数第n个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        if (len == n)
            return head.next;
        int i = len - n;
        while (i > 1) {
            i--;
            cur = cur.next;
        }
        if (cur != null && cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
