package interview.华为OD;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-11 20:58
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(get(s));
        }
    }

    // 7#6$5#12
    public static int get(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '*';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '*') stack.push(num);
                if (sign == '#') {
                    int res = count(stack.pop(), num, sign);
                    stack.push(res);
                }
                if (sign == '$') {
                    stack.push(num);
                }
                num = 0;
                sign = c;
            }
        }
        int ans = stack.size() > 1 ? 0 : stack.peek();
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (!stack.isEmpty()) {
                int y = stack.peek();
                ans += count(y, x, '$');
            }
        }
        return ans;
    }

    public static int count(int x, int y, char c) {
        if ('#' == c) return 4 * x + 3 * y + 2;
        else return 2 * x + y + 3;
    }
}
