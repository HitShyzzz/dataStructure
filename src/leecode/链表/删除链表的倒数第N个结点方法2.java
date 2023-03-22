package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/31/11:51
 * @Description:
 */
public class 删除链表的倒数第N个结点方法2 {
    /**
     * 双指针，增加亚结点pre,位于head的前面，当fast和pre走len-n步,fast走到了链尾，pre刚好走到待删除结点的前一个位置！
     * O(T)=O(len),
     * O(S)=O(1);
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        // 删除的是头指针
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        // 删除的是尾部结点
        if (n == 1) {
            pre.next = null;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }
}
