package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/19:52
 * @Description:
 */
public class 环形链表 {
    /**
     * 利用双指针，快指针每次走两步，慢指针每次走1步，当快慢指针相遇时说明存在环！
     * O(T)=O(n),每个结点都需要访问到；
     * O(S)=O(1)，只需要常数空间来存储变量！
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
