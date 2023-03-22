package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/01/11:08
 * @Description:
 */
public class 链表相加2 {
    /**
     * 此时这两个链表都是正序的，思路就是先把这两个链表反转，再按照链表相加1的方法进行相加，最后再把得到的逆序链表反转
     * 得到正序链表！
     * O(T)=O(m+n);首先反转两个链表需要O(m+n),然后再去对链表求和需要O(m+n),最后反转新的链表需要O(math.max(m,n));
     * 合起来就是O(m+n);
     * O(S)=O(1);
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead1 = reverse(head1);
        ListNode newHead2 = reverse(head2);
        ListNode head = null;
        ListNode tail = head;
        int carry = 0;
        while (newHead1 != null || newHead2 != null) {
            int n1 = (newHead1 == null ? 0 : newHead1.val);
            int n2 = (newHead2 == null ? 0 : newHead2.val);
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = (sum / 10);
            if (newHead1 != null) {
                newHead1 = newHead1.next;
            }
            if (newHead2 != null) {
                newHead2 = newHead2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        ListNode res = reverse(head);
        return res;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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
