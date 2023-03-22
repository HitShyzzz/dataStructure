package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/13/22:55
 * @Description:
 */
public class 重排链表方法2 {
    public static void main(String[] args) {

    }

    // 1-2-3-4-5---》1-5-2-4-3
    public void reorderList(ListNode head) {
        // 找到链表的中间结点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 从中间断开链表
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode l2 = reverse(head2);
        ListNode l1 = head;
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
