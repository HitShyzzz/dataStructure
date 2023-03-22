package leecode.链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/13/22:55
 * @Description:
 */
public class 重排链表 {
    public static void main(String[] args) {

    }
    // 1-2-3-4-5---》1-5-2-4-3
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            map.put(i, cur);
            i++;
            cur = cur.next;
        }
        for (int j = 0; j <= (i - 1) / 2; j++) {
            list.add(map.get(j));
            list.add(map.get(i - 1 - j));
        }
        if (i % 2 != 0) {
            list.remove(list.size() - 1);
        }
        for (int j = 0; j < list.size() - 1; j++) {
            ListNode node = list.get(j);
            node.next = list.get(j + 1);
        }
        list.get(list.size() - 1).next = null;
    }
}
