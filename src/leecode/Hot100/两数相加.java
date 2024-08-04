package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 18:47
 */
public class 两数相加 {
    // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    // 输出：[8,9,9,9,0,0,0,1]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode tail = head;
        int change = 0;
        while (l1 != null || l2 != null) {
            int a = (l1 == null ? 0 : l1.val);
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + change;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            change = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (change != 0) {
            tail.next = new ListNode(change);
        }
        return head.next;
    }
}
