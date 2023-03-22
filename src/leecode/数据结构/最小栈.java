package leecode.数据结构;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/16:19
 * @Description:
 */
public class 最小栈 {

}

/**
 * 思路：设置一个辅助栈，辅助栈的栈顶元素就是数据栈的最小值！在push时，辅助栈push的是栈顶元素和当前元素的较小者，
 * 在pop时，辅助栈也要进行pop;
 */
class MinStack {

    Deque<Integer> second;// 辅助栈，存的是数据栈的最小值！
    Deque<Integer> data;// 数据栈

    public MinStack() {
        second = new LinkedList<>();
        data = new LinkedList<>();
        second.push(Integer.MAX_VALUE);// 避免push时产生空指针异常，先push最大值！
    }

    public void push(int val) {
        data.push(val);
        second.push(Math.min(second.peek(), val));
    }

    public void pop() {
        data.pop();
        second.pop();

    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return second.peek();
    }
}

