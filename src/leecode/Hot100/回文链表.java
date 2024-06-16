package leecode.Hot100;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 17:35
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 1、快慢指针找到链表的中间节点mid
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        // 2、反转链表后半段
        ListNode mid = reverseList(slow);
        // 3、依次比较前半段和反转后的后半段链表
        while (mid != null) {
            if (head.val != mid.val) return false;
            mid = mid.next;
            head = head.next;
        }
        // 4、还原后半段链表，不破坏链表原有结构
        reverseList(slow);
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
