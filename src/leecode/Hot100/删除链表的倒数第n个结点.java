package leecode.Hot100;

import java.awt.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-01 21:44
 */
public class 删除链表的倒数第n个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        // 1.求链表的长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len == n)
            return head.next;
        // 2.再从前往后走len-n-1步
        cur = head;
        int i = 1;
        while (i < len - n) {
            i++;
            cur = cur.next;
        }
        // 删除倒数第n个结点
        if (cur != null && cur.next != null)
            cur.next = cur.next.next;
        return head;
    }
}
