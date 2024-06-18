package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 快慢指针，快慢指针第一次相遇时，把慢指针放到起点，快慢指针同时每次只走一步，
 * 再相遇时就是链表的入环点
 * @date: 2024-06-18 22:12
 */
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
