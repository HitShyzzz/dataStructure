package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/21/10:18
 * @Description:
 */
public class 删除链表的倒数第N个结点 {
    /**
     * 先求出链表的长度size,只要把头指针向后移动size-n-1步，就找到了待删除节点的前驱节点pre,只要让pre.next=pre.next.next,
     * 就能把待删除节点删除！
     * O(T)=O(size)，只需要1次遍历链表即可；
     * O(S)=O(1)，
     *
     * @param head 头结点
     * @param n    要删除的倒数第n个节点
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先求出链表长度
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        // 找到待删除节点的前驱节点pre
        for (int i = 1; i < size - n; i++) {
            cur = cur.next;
        }
        ListNode pre = cur;// 待删除节点的前驱节点pre
        if (n == size) {// 删除的是头节点
            head = pre.next;
        } else if (n == 1) {// 删除的是尾部节点
            pre.next = null;
        } else {// 删除的是中间节点
            pre.next = pre.next.next;// 删除节点
        }
        return head;
    }
}
