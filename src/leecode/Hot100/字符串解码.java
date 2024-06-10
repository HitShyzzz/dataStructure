package leecode.Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-10 16:04
 */
public class 字符串解码 {
    public static void main(String[] args) {
        字符串解码 字符串解码 = new 字符串解码();
        String s = "2[abc]3[cd]ef";
        String s1 = 字符串解码.decodeString(s);
        System.out.println(s1);
    }

    // 输入：s = "3[a2[c]]"
    // 输出："accaccacc"
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return dfs(queue);
    }

    // 这里选择队列存储数组的元素是为了保证已经遍历过的元素不会重复遍历
    public String dfs(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int repCnt = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                // 重复的元素次数可能是多位的，如12[abc]
                repCnt = repCnt * 10 + c - '0';
            } else if (c == '[') {
                String cur = dfs(queue);
                while (repCnt > 0) {
                    sb.append(cur);
                    repCnt--;
                }
            } else if (c == ']') {
                return sb.toString();
            } else sb.append(c);
        }
        return sb.toString();
    }
}
