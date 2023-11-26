package leecode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-26 14:39
 */
public class 统计子串中的唯一字符方法2 {
    public static void main(String[] args) {
        String s = "LEETCODE";
        int i = uniqueLetterString(s);
        System.out.println(i);
    }

    // 输入: s = "ABC"
    // 输出: 10
    // 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
    // 其中，每一个子串都由独特字符构成。
    // 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10

    /**
     * @description: 计算每个字符对于子串中唯一字符数量的贡献，
     * 对于每个字符，只需要计算包含该字符依次子串的数量即可！
     * @author: shy
     * @date: 2023/11/26 15:09
     * @param:
     * @param: s
     * @return: int
     **/
    public static int uniqueLetterString(String s) {
        int ans = 0;
        // key是每个字符，value是每个字符出现的下标集合
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                // 左边界（不包含）
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            // 右边界（不包含）
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                ans += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return ans;
    }
}
