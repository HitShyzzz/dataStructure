package leecode.双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/08/20:00
 * @Description:
 */
public class 环形链表II方法2 {
    /**
     * 使用set记录已经访问过的结点，如果再次访问到这个结点说明，这个点有环，这个点也就是入环点！
     * O(T)=O(n),每个点至多访问两次，
     * O(S)=O(n);
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
