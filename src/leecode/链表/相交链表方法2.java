package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/16:47
 * @Description:
 */
public class 相交链表方法2 {
    /**
     * 哈希集的空间复杂度是O(m),下面利用双指针的方法把空间复杂度优化到O(1);
     * 设相遇前链表A的长度是a,链表B的长度是b,公共长度是L,那么a+L=la;b+L=lb;
     * 因此la+b=lb+a;
     * 所以定义指针pa和pb分别放到headA和headB的位置上，不断向后移动pa和pb,如果pa为空了，就把pa放到headB的位置上，
     * 如果pb为空了，就把pb放到headA的位置上，当pa和pb再次相遇时，就是第一次相遇的位置！
     * O(T)=O(m+n),最坏情况下时间复杂度是O(2(m+n))
     * O(S)=O(1);
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }
}
