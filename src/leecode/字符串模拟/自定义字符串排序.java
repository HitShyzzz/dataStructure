package leecode.字符串模拟;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/13/11:04
 * @Description:
 */
public class 自定义字符串排序 {
    public static void main(String[] args) {
        String order = "kqep";
        String s = "pekeq";
        String s1 = customSortString(order, s);
        System.out.println(s1);
    }

    //  order = "kqep", s = "pekeq"---》kqeep
    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        // 先去统计字符串s中每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                // 添加所有的字符c
                for (int j = 0; j < map.get(c); j++) {
                    sb.append(c);
                }
            }
        }
        StringBuilder s1=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(s.substring(i, i + 1)) == -1) {
                s1.append(s.charAt(i));
            }
        }
        return sb +s1.toString();
    }
}
