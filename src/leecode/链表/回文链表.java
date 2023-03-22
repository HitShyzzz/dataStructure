package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/20:24
 * @Description:
 */
public class 回文链表 {
    /**
     * 把结点值加入到数组中，然后再去判断是否是回文的！
     * O(T)=O(len),len是链表的长度；
     * O(S)=O(len),需要O(len)的额外空间来存储链表中的结点值！
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        int len = 0;// 计算链表的长度
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] node = new int[len];
        for (int i = 0; i < len; i++) {
            node[i] = head.val;
            head = head.next;
        }
        return valid(node);
    }

    /**
     * 判断node数组是否是回文的
     *
     * @param node
     * @return
     */
    public boolean valid(int[] node) {
        int l = 0;
        int r = node.length - 1;
        while (l < r) {
            if (node[l] != node[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
