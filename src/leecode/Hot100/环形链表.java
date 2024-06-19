package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-19 20:58
 */
public class 环形链表 {
    // 快慢指针，快慢指针只要相遇，就说明存在环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            slow = slow.next;
            if (slow == fast) return true;

        }
        return false;
    }
}
