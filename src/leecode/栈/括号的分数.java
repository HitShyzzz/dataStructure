package leecode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/09/21:32
 * @Description:
 */
public class 括号的分数 {
    public static void main(String[] args) {
        String s ="(()(()))";
        int i = scoreOfParentheses(s);
        System.out.println(i);
    }
    public static int scoreOfParentheses(String s) {
        int n = s.length();
        // 栈顶存放的是当前平衡括号的得分
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.isEmpty() ? 0 : stack.pop() + Math.max(2 * v, 1);
                stack.push(top);
            }
        }
        return stack.peek();
    }
}
