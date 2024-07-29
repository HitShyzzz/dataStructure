package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 先合并两个有序链表，再依次合并两个链表
 * @date: 2024-07-29 21:54
 */
public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode node : lists) {
            head = mergeTwoList(head, node);
        }
        return head;
    }

    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) tail.next = head1;
        if (head2 != null) tail.next = head2;
        return head.next;
    }
}
