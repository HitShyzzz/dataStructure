package leecode.top50;

import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-29 20:25
 */
public class 删除链表的倒数第n个结点方法2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        int i = 0;
        while (i < n) {
            first = first.next;
            i++;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode second = dummyNode;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}
