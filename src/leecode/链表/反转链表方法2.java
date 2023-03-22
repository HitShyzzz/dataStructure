package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/23:22
 * @Description:
 */
public class 反转链表方法2 {
    /**
     * 递归写法，其实对于每个点都是让cur.next=prev;
     * prev=cur;
     * O(T)=O(n);
     * O(S)=O(n);递归空间栈的调用，最多为n层！
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // 用两个结点一看就明白了！
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
