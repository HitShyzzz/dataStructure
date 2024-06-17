package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 21:22
 */
public class MinStack {

    // 数据栈
    private Deque<Integer> stack;

    // 辅助栈，存放的是数据栈的最小值
    private Deque<Integer> second;

    public MinStack() {
        stack = new ArrayDeque<>();
        second = new ArrayDeque<>();
        second.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        second.push(Math.min(second.peek(), val));
    }

    public void pop() {
        stack.pop();
        second.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return second.peek();
    }
}
