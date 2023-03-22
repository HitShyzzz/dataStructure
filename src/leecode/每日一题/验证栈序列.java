package leecode.每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/31/9:49
 * @Description:
 */
public class 验证栈序列 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);

    }

    // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]--->true
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;// popped数组的指针
        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            // 当栈顶元素==popped数组当前元素时就出栈，
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        // 栈为空，就是合法的，否则就是不合法的！
        return stack.isEmpty();
    }
}
