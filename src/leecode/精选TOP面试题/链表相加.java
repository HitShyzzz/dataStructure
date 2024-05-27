package leecode.精选TOP面试题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-05 21:10
 */
public class 链表相加 {
    // 输入：l1 = [2,4,3], l2 = [5,6,4]
    // 输出：[7,0,8]
    // 解释：342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tail = null;
        ListNode head = null;
        int change = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + change;
            change = sum / 10;
            sum = sum % 10;
            if (head == null) {
                tail = head = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (change > 0) {
            tail.next = new ListNode(change);
        }
        return head;
    }
}
