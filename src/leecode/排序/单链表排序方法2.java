package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/01/12:15
 * @Description:
 */
public class 单链表排序方法2 {
    public ListNode sortInList(ListNode head) {
        // write code here
        return sort(head, null);
    }

    // 归并排序，自顶向下递归的去实现，
    // O(T)=O(nlogn);
    // O(S)=O(logn);
    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 利用快慢指针找到mid位置
        ListNode fast = head;
        ListNode slow = head;
        // 这里注意要写成fast!=tail,不要写成fast!=null,因为对于递归的前半段，其实走到mid位置链表就结束了！
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode sort1 = sort(head, mid);
        ListNode sort2 = sort(mid, tail);
        ListNode sorted = merge(sort1, sort2);
        return sorted;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return dummyNode.next;
    }
}
