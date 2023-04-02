package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/02/11:03
 * @Description:
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        // 1.找到链表中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode newHead = reverse(head2);
        merge(head, newHead);
    }
    // 2.反转右半部分链表
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    // 3.合并链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode l1 = head1;
        ListNode l2 = head2;
        while (l1 != null && l2 != null) {
            ListNode nex1 = l1.next;
            ListNode nex2 = l2.next;
            l1.next = l2;
            l2.next = nex1;
            l1 = nex1;
            l2 = nex2;
        }
        return head1;
    }
}
