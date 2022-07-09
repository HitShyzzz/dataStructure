package leecode.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/16:40
 * @Description:
 */
public class 相交链表 {
    /**
     * 把链表A放到哈希集中，遍历B，如果当前结点在哈希集中已经存在了，说明就是第一次相交的位置！
     * O(T)=O(m+n);
     * O(S)=O(m);m是链表A的长度！
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
