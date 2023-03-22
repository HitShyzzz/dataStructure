package leecode.双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/08/19:54
 * @Description:
 */
public class 环形链表方法2 {
    /**
     * 使用set记录每个访问过的结点，如果再次访问到已经添加到set里的结点，就说明有环！
     *O(T)=O(n);每个结点都最多访问两次；
     * O(S)=O(n);set中最多添加n+1个结点！
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
