package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/08/19:16
 * @Description:
 */
public class 环形链表II {

    /**
     * 通过画图我们不难发现，当快慢指针相遇时，从头指针到入环点的距离和快慢指针相遇点入环点的距离是相等的，如果是
     * 快指针的话可能还会有n倍的环长度关系，
     * 那么我们先让快慢指针相遇，然后再放个指针ptr在头结点的位置，让ptr和slow指针同时移动，当这个指针相遇时。就是
     * 入环点；不管是前面先让快慢指针相遇，还是后面的让ptr和slow指针相遇，访问的结点数都不会超过O(n);
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
