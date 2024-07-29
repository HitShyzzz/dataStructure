package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 在方法1的基础上进行优化，分治合并，将k个链表进行配对分组，第一次合并得到k/2个链表，然后是k/4,k/8,...
 * O(T)=O(NlogK)，O(S)=O(N)
 * @date: 2024-07-29 21:54
 */
public class 合并K个升序链表方法2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
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
