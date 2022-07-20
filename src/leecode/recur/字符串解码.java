package leecode.recur;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/17/9:34
 * @Description:
 */
public class 字符串解码 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }

    /**
     * 递归，对于每个字符分3种情况；
     * 如果s[i]是数字，那么就要算出来重复的次数；
     * 如果s[i]是"["那么就要解析出‘[’后面的字符串，进行重复；
     * 如果s[i]是']'就返回；
     * 如果s[i]是字母，就直接添加到结果集中；
     * O(T)=O(n);n是字符串的长度，往队列里添加元素和从队列中弹出元素时间复杂度都是O(n);
     * O(S)=O(n);空间复杂度主要来自递归空间栈的调用！
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        return recur(queue);
    }

    public static String recur(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int repTime = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                repTime = repTime * 10 + c - '0';//这样写是为了应对两位数，三位数的情况。如12[bc],123[bc];
            } else if (c == '[') {
                String str = recur(queue);
                while (repTime > 0) {
                    sb.append(str);
                    repTime--;
                }
            } else if (c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
