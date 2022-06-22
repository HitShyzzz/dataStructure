package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/22/10:43
 * @Description:
 */
public class 合并K个升序链表方法2 {
    /**
     * 分治合并，第一次合并之后还剩下k/2个链表，第二次还剩k/4,。。。依次类推！
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并lists[l,r]的链表
     *
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ListNode[] lists, int l, int r) {
        // 递归出口
        if (l == r) {
            return lists[l];
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists1(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 非递归写法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
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
