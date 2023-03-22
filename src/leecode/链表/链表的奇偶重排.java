package leecode.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/10:15
 * @Description:
 */
public class 链表的奇偶重排 {
    /**
     * 思路：用集合list把链表的元素全部存进去，然后先连接奇数位的结点，再连接偶数位的结点就好了！
     * O(T)=O(n);
     * O(S)=O(n);
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int n = list.size();
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 != 0) {
                tail.next = list.get(i);
                tail = tail.next;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 0) {
                tail.next = list.get(i);
                tail = tail.next;
            }
        }
        tail.next = null;
        return dummyNode.next;
    }
}
