package leecode.链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/02/10:49
 * @Description:
 */
public class 链表的奇偶重排方法2 {
    /**
     * 双指针，odd指针指向奇数位，even指针指向偶数位，每次odd.next=even.next,even.next=odd.next;
     * 最后把偶数位置的头结点接到奇数位的最后一个结点就好了！
     * o(T)=O(n);
     * O(S)=O(1);
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;// 偶数位置的头结点，后面连接链表的时候需要！
        // even指针在后面来控制是否到达链尾
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
