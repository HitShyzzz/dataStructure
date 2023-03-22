package leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/23/9:02
 * @Description:
 */
public class 字符串解码 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }

    public static String decodeString(String s) {
        // 使用队列避免了下标的记录！
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        return dfs(queue);
    }

    public static String dfs(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int repTime = 0;// 表示需要重复的次数
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            // 数字的话需要记录重复的次数
            if (Character.isDigit(cur)) {
                // 这样写是为了应对重复两位数的情况，比如12[bc].
                repTime = repTime * 10 + cur - '0';
            } else if (cur == '[') {// '['开始添加
                String str = dfs(queue);// 解析出'['后面的内容
                // 把'['后面的内容重复repTime次
                while (repTime > 0) {
                    sb.append(str);
                    repTime--;
                }
            } else if (cur == ']') {// 右括号结束
                return sb.toString();
            } else {// 是字符的话就直接添加
                sb.append(cur);
            }
        }
        return sb.toString();
    }

}
