package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/20:33
 * @Description:
 */
public class 回文链表放法2 {

    /**
     * 先用快慢指针找到链表的中间mid,然后反转后半段链表，依次去判断每个位置的值是否相等，
     * 最后为了不破坏链表的结构，再反转一下后半段链表，把链表还原；
     * 至于反转链表的放法，前面已经写过了！
     * O(T)=O(n),n是链表的长度；
     * O(S)=O(1)；
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode mid = reverseList(slow);
        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        // 再反转一下把链表还原
        reverseList(slow);
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
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
