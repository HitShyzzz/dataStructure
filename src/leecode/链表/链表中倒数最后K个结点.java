package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/31/10:54
 * @Description:
 */
public class 链表中倒数最后K个结点 {
    /**
     * 思路：先求出链表长度，len,那么让头指针走len-k步，刚好就到了倒数第k个结点！
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }
        int len = 0;
        ListNode cur = pHead;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (k > len) {
            return null;
        }
        ListNode node = pHead;
        for (int i = 0; i < len - k; i++) {
            node = node.next;
        }
        return node;
    }
}
