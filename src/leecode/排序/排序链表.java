package leecode.排序;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/10:06
 * @Description:
 */
public class 排序链表 {

    /**
     * 自顶向下的归并排序，归并排序，其实就是一种分治思想，每次把[l,mid]和[mid,r]分别进行排序，然后再把两端排序的
     * 结果合并起来就好了！
     * O(T)=O(nlogn);
     * O(S)=O(logn);主要来自递归空间栈的调用！
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail) {
        // 递归的出口，当链表为空时，就不要再分了！
        if (head == null) {
            return head;
        }
        // 当链表只有一个结点时，也不要再分了！
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 找中间结点mid时，我们可以利用快慢指针的方法，快指针每次走两步，慢指针每次走1步，当快指针走到末尾时，
        // 慢指针刚好走到中间位置
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    /**
     * 合并两个有序链表，这是前面写过的！
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 亚结点
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        }
        if (list2 == null) {
            tail.next = list1;
        }
        return head.next;
    }
}
