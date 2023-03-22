package leecode.字符串模拟;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/06/18:21
 * @Description:
 */
public class 统计子串中的唯一字符方法2 {
    public static void main(String[] args) {
        String s="LEETCODE";
        int i = uniqueLetterString(s);
        System.out.println(i);
    }
    public static int uniqueLetterString(String s) {
        // 统计字符c出现的下标
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                // 上次出现的下标设为-1;
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int count = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                count += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return count;
    }
}
