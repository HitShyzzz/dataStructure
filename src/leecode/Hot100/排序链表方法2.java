package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 分治算法，O(T)=O(nlogn)，O(S)=O(1)
 * 符合题目要求
 * @date: 2024-06-18 20:17
 */
public class 排序链表方法2 {
    // 输入：head = [4,2,1,3]
    // 输出：[1,2,3,4]
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    /**
     * @description:
     * @return: 以head为头，tail为尾的链表从小到大排序后的头指针
     **/
    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 快慢指针找到链表的中间结点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }
        ListNode mid = slow;
        //mid.next=null;
        // 对【head,mid】的链表排序
        ListNode head1 = sort(head, mid);
        // 对【mid，tail】的链表排序
        ListNode head2 = sort(mid, tail);
        // 合并【head,mid】和【mid，tail】两段有序链表
        ListNode merge = merge(head1, head2);
        return merge;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode prev = new ListNode(-1);
        ListNode tail = prev;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) tail.next = head1;
        if (head2 != null) tail.next = head2;
        return prev.next;
    }
}
