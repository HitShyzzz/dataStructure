package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 21:03
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        // a+b+c=a+c+b，则a+Lb=La+b
        // a走到了链表末尾，就把a指针拿到b的头部
        // b走到了链表末尾，就把b指针拿到a的头部
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
