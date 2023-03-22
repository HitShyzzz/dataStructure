package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/15:21
 * @Description:
 */
public class 删除有序链表中的重复元素II方法2 {
    /**
     * 直接法，当遇到相邻相同的，直接全部跳过，并且把开始相同的前一个结点pre连接到第一个结点值不相同的结点上cur.next!
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1->1->1->1->2
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
