package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/10:11
 * @Description:
 */
public class 无重复最长子串方法2 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp = 0;// dp表示的是以s[i]结尾且最长无重复子串开始的下标
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer repeatIndex = map.get(c);
            if (repeatIndex != null && repeatIndex >= dp) {
                dp = repeatIndex + 1;
            }
            res = Math.max(res, i - dp + 1);
            map.put(c, i);
        }
        return res;
    }
}
