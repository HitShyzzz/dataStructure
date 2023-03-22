package interview.四399;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/15/21:13
 * @Description:
 */
public class 验证栈序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = s.substring(1, s.length() - 1);
        String[] s2 = s1.split(",");
        int[] pushed = new int[s2.length];
        for (int i = 0; i < pushed.length; i++) {
            pushed[i] = Integer.valueOf(s2[i]);
        }
//        for (int i = 0; i < pushed.length; i++) {
//            System.out.print(pushed[i]+" ");
//        }
//        System.out.println();
        String s3 = in.nextLine();
        String s4 = s3.substring(1, s3.length() - 1);
        String[] s5 = s4.split(",");
        int[] poped = new int[s5.length];
        for (int i = 0; i < poped.length; i++) {
            poped[i] = Integer.valueOf(s5[i]);
        }
//        for (int i = 0; i < poped.length; i++) {
//            System.out.print(poped[i]+" ");
//        }
//        System.out.println();
        boolean b = validateStackSequences(pushed, poped);
        System.out.println(b);
    }

    // [1,2,3,4] [4,3,2,1]-->true
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int n = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
