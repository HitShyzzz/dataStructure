package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-31 10:44
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    // 输入：s = "()[]{}"
    // 输出：true
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左括号就入队
            if (stack.isEmpty() || '(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {// 右括号就拿栈顶元素开始匹配
                char peek = stack.peek();
                // 能匹配上就弹出栈
                if (map.containsKey(peek) && map.get(peek) == c) {
                    stack.pop();
                } else {// 否则就直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
