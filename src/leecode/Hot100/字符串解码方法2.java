package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-10 16:04
 */
public class 字符串解码方法2 {
    public static void main(String[] args) {
        字符串解码方法2 字符串解码 = new 字符串解码方法2();
        String s = "2[abc]3[cd]ef";
        String s1 = 字符串解码.decodeString(s);
        System.out.println(s1);
    }

    // 输入：s = "3[a2[c]]"
    // 输出："accaccacc"
    // 双栈法
    public String decodeString(String s) {
        Deque<Integer> num_stack = new ArrayDeque<>();
        Deque<String> string_stack = new ArrayDeque<>();
        String cur = "";
        int repCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                repCnt = repCnt * 10 + c - '0';
            } else if (c == '[') {
                num_stack.push(repCnt);
                // string_stack存的是‘[’之前已经累积的字符串
                string_stack.push(cur);
                repCnt = 0;
                cur = "";
            } else if (c == ']') {
                int cnt = num_stack.pop();
                String str = string_stack.pop();
                StringBuilder sb = new StringBuilder(str);
                while (cnt > 0) {
                    sb.append(cur);
                    cnt--;
                }
                cur = sb.toString();
            } else {
                cur += c;
            }
        }
        return cur;
    }
}
