package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/29/22:47
 * @Description:
 */
public class 链表内指定区间反转 {
    /**
     * 先把要反转的子链表反转，再把原来的链表拼接回来！
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        // 设置亚结点，避免对头节点的讨论
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prevLeft = dummyNode;
        // start指针走m-1步到达要反转结点的前一个结点
        for (int i = 0; i < m - 1; i++) {
            prevLeft = prevLeft.next;
        }
        ListNode left = prevLeft.next;
        ListNode node = left;
        // 从left结点走n-m步到达右结点
        for (int i = 0; i < n - m; i++) {
            node = node.next;
        }
        ListNode right = node.next;
        // 断开原来的链表
        prevLeft.next = null;
        node.next = null;
        // 反转子链表
        reverse(left);
        // 拼接没有反转的链表
        prevLeft.next = node;
        left.next = right;
        return dummyNode.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
}
