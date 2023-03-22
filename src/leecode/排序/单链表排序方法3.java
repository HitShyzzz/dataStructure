package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/01/17:04
 * @Description:
 */
public class 单链表排序方法3 {
    /**
     * 自底向上的归并排序，把空间复杂度优化到O(1)；
     * 每次把链表拆成两个sublen长度的子链表进行合并，细节代码里都有注释！
     * O(T)=O(nlogn);
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        // 先求出链表的长度
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        // 引入亚结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode pre = dummyNode;// 记录链表拆分处的前一个位置，在合并排序后的链表时有用
            ListNode cur = dummyNode.next;// 记录链表拆分的位置
            while (cur != null) {// 链表没有拆分完
                ListNode head1 = cur;// 记录拆分的第一个子链表的头结点位置
                // 先拆出来长度为subLen的子链表1
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;// 第二个子链表的头结点就是第一个子链表尾部后面的一个结点
                cur.next = null;// 断开第一个子链表的连接
                cur = head2;
                // 拆出来长度为subLen的子链表2
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode nex = null;// 拆开的第二个链表末尾的后一个位置
                if (cur != null) {
                    nex = cur.next;// 记录链表拆分的位置
                    cur.next = null;// 断开第二个子链表的连接
                }
                // 合并拆分出来的两个子链表
                ListNode merge = merge(head1, head2);
                pre.next = merge;
                // pre指针要走2倍的subLen距离到达第二个链表的末尾位置，也就是下次合并的前一个位置
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = nex;
            }
        }
        return dummyNode.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null ? l2 : l1);
        return dummyNode.next;
    }
}
