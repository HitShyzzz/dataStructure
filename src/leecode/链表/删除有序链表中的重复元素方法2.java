package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/11:24
 * @Description:
 */
public class 删除有序链表中的重复元素方法2 {
    /**
     * 单指针，当遇到前后相同的元素直接跳过，当前后结点的值不相同时，就让tail指针指向它就好了！
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode tail = cur;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                tail.next = cur.next;
                tail = tail.next;
            }
            cur = cur.next;
        }
        tail.next = null;
        return head;
    }
}
