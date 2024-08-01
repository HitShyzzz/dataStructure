package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 用双指针，不用先去计算链表的长度
 * @date: 2024-08-01 21:44
 */
public class 删除链表的倒数第n个结点方法2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        // first指针先走n步
        ListNode first = head;
        int i = 0;
        while (i < n) {
            i++;
            first = first.next;
        }
        // 此时second结点再从哑结点出发，当first指针走到末尾时，second指针恰好走到倒数第n个结点的前置结点
        ListNode dummyNode = new ListNode(-1, head);
        ListNode second = dummyNode;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}
