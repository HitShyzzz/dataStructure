package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/21/16:24
 * @Description:
 */
public class 合并两个有序链表 {
    /**
     * 递归写法
     *O(T)=O(m+n)，需要遍历所有的结点，m是list1的长度，n是list2的长度；
     * O(S)=O(m+n),递归空间栈的使用！
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归出口
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            // 这个函数的功能就是返回合并之后的头结点
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
