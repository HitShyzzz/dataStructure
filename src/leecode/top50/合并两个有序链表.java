package leecode.top50;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-31 8:17
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
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
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return dummyNode.next;
    }
}
