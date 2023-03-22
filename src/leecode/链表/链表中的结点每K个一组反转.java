package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/30/9:49
 * @Description:
 */
public class 链表中的结点每K个一组反转 {
    /**
     * 对于每一组的k个结点链表，反转k-1次就达到了目的，
     * 如1->2->3->4->5,k=3;
     * 0->1->2->3->4,cur=1,先把这个串反转成0->2->1->3->4，cur=1;
     * 再把0->1->2->3->4反转成0->3->2->1->4，一个分组内的就完成了！
     * 对于每次反转:
     * nex=cur.next;nex->2
     * cur.next=nex.next;1->3
     * nex.next=pre.next;2->1
     * pre.next=nex;0->2
     * 最终变成了0->2->1->3->4，cur=1
     * O(T)=O(len),总共有len/k个分组，每个分组需要反转k-1次，每次反转时间复杂度都是常数级别的，总的时间复杂度就是O(len),
     * O(S)=O(1);
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        // 先求出链表的长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        cur = head;
        // 总共需要反转len/k个分组，多的拿下来就行！
        for (int i = 0; i < len / k; i++) {
            // 每个分组内需要反转k-1次
            for (int j = 1; j < k; j++) {
                ListNode nex = cur.next;
                cur.next = nex.next;
                // nex.next=cur是错误的，这份拼接的上一次反转后的头部，
                nex.next = pre.next;
                pre.next = nex;
            }
            // 每次反转后，我们也需要cur指针和pre指针后移
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
