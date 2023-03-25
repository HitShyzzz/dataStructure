package interview.meituan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/19:05
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int m = sc.nextInt();
            int[] in = new int[m];
            for (int i = 0; i < m; i++) {
                in[i] = sc.nextInt();
            }
            int[] out = new int[m];
            for (int i = 0; i < m; i++) {
                out[i] = sc.nextInt();
            }
            boolean b = check(in, out);
            if (b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            n--;
        }
    }

    public static boolean check(int[] in, int[] out) {
        int n = in.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() == out[j]) {
                stack.pop();
                j++;
            }
            stack.push(in[i]);
        }
        return stack.isEmpty();
    }
}
