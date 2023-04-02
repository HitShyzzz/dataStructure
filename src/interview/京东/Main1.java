package interview.京东;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/19:45
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        // 9999 8888
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        String s1 = s.substring(0, 4);
       // System.out.println(s1);
        String s2 = s.substring(5, s.length());
       // System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println(0);
        }
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(s1);
        Set<String> set = new HashSet<>();
        set.add(s1);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String key : get(cur)) {
                    if (!set.contains(key)) {
                        if (key.equals(s2)) {
                            System.out.println(res);
                        }
                        queue.offer(key);
                        set.add(key);
                    }
                }
            }
        }
        // System.out.println(res);
    }

    // 得到旋转一次得到的数字
    public static List<String> get(String cur) {
        List<String> res = new ArrayList<>();
        char[] array = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = array[i];
            array[i] = (c == '0' ? '9' : (char) (c - 1));
            res.add(new String(array));
            array[i] = c;
        }
        return res;
    }
}


