package leecode.链表;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/11:17
 * @Description:
 */
public class 删除有序链表中的重复元素 {
    /**
     * 利用treeSet去重的同时使得链表中的元素有序！
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>();
        ListNode cur = head;
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            tail.next = new ListNode(iterator.next());
            tail = tail.next;
        }
        return dummyNode.next;
    }
}
