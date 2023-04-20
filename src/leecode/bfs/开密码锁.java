package leecode.bfs;

import interview.常考面试题.ListNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/20/10:22
 * @Description:
 */
public class 开密码锁 {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int i = openLock(deadends, target);
        System.out.println(i);
    }

    // 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //输出：6
    //解释：
    //可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
    //注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这个锁就会被锁定。
    public static int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        Set<String> seen = new HashSet<>();// 记录遍历过的字符串
        seen.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String s : get(cur)) {
                    if (!seen.contains(s) && !dead.contains(s)) {
                        if (s.equals(target)) {
                            return step;
                        }
                        seen.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;
    }

    // 得到旋转字符串s一位得到的所有字符串
    public static List<String> get(String s) {
        List<String> list = new ArrayList<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = array[i];
            array[i] = (c == '0' ? '9' : (char) (c - 1));
            list.add(new String(array));
            array[i] = (c == '9' ? '0' : (char) (c + 1));
            list.add(new String(array));
            array[i] = c;// 要把前面的还原到原来的位置
        }
        return list;
    }
}
