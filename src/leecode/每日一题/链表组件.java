package leecode.每日一题;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/12/20:10
 * @Description:
 */
public class 链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean inSet = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {// 连续出现的只计算起始位置就行
                    inSet = true;
                    ans++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
