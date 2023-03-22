package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/31/10:57
 * @Description:
 */
public class 链表中倒数最后K个结点方法2 {
    /**
     * 方法1需要两遍扫描，我们可以利用两个指针来代替求链表长度的操作，
     * 先让fast指针走k步，那么还要走len-k步到链表尾部，这时我们让slow指针从头指针开始走，
     * 当fast指针走n-k步到链表尾部时，slow指针也刚好走n-k步刚好到倒数第K个结点位置！
     * O(T)=O(n);这里虽然还是两遍扫描，但第一遍扫描需要O(k)，第二遍扫描需要O(len-k),合起来还是O(len);
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
        ListNode fast = pHead;
        // 先让fast走k步
        for (int i = 0; i < k; i++) {
            // 如果k大于len,那么fast已经为空了，就直接返回null;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // 再让fast和slow同时走n-k步，fast刚好到链尾，slow刚好到倒数第K个结点位置！
        ListNode slow = pHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
