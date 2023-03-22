package leecode.链表;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/11:36
 * @Description:
 */
public class 删除有序链表中的重复元素II {
    /**
     * 思路：先用map去统计每个字符出现的次数，因为要保证按照插入的顺序进行拼接，这里使用linkedHashMap,
     * 然后去拼接出现次数==1的node就行了!
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // 1->2->2
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        for (Integer node : map.keySet()) {
            if (map.get(node) < 2) {
                tail.next = new ListNode(node);
                tail = tail.next;
            }
        }
        return dummyNode.next;
    }
}
