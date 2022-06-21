package leecode.栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/21/11:15
 * @Description:
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String s = "{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    /**
     * 核心点：后加入的左括号要先闭合！如果闭合不了就是无效的！因此我们利用栈把左括号放到栈顶，把栈顶元素和右括号进行比较，
     * 如果相等，说明栈顶的左括号匹配成功，就让它出栈，继续比较下一个左括号；最后如果栈为空，也就是所有的左括号都有的匹配
     * 就是有效的，否则就是无效的！
     * O(T)=O(n),需要遍历一次字符串s;
     * O(S)=O(n+|Σ|)，|Σ|是字符的数量，记录括号的匹配关系需要HashMap,O(|Σ|);栈空间需要O(n)，合起来就是总的空间复杂度；
     * 其实栈放的都是左括号，一般情况下栈空间大小是左括号的数量，但最坏情况下，s全是左括号，就是O(n);因此O(S)=O(n+|Σ|);
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int n = s.length();
        // s长度是奇数，那么左括号数和右括号数一定不相等，直接false；
        if (n % 2 != 0) {
            return false;
        }
        // 记录括号的匹配关系，key是右括号，value是左括号，这么做就是为了方便取左括号的值，
        // 栈里面都是左括号！
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // 存放左括号的栈
        Deque<Character> stack = new LinkedList<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(c[i])) {// 此时c[i]是右括号
                // 前者是说上来就是右括号，此时肯定是无效的！
                if (stack.isEmpty() || stack.peek() != map.get(c[i])) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c[i]);// 栈中只放左括号！
            }
        }
        return stack.isEmpty();
    }
}
