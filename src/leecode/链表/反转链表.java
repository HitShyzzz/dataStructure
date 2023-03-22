package leecode.链表;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/22:52
 * @Description:
 */
public class 反转链表 {

    /**
     * 迭代法：核心就是让cur.next=prev;prev=cur;cur=nex;
     * O(T)=O(n)；
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
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
