package leecode.链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/22/11:00
 * @Description:
 */
public class 合并K个升序链表方法3 {

    /**
     * 优先级队列，每次找出每个链表头结点的最小的那个，然后依次向后取，每次都能最小的那个加到结果集中，
     * 考虑优先级队列这种数据结构！
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // 先把所有链表的头结点加入到优先级队列中！
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = tail.next;
            // cur初始指向的是每个链表的头结点，然后我们还需要依次去遍历每个链表的所有结点
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return head.next;
    }
}
