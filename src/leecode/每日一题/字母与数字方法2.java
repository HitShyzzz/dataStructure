package leecode.每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/11/8:22
 * @Description:
 */
public class 字母与数字方法2 {

    // 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
    //
    //输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        // 记录前缀和sum第一次出现的下标
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int startIndex = -1;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            // 再次出现相同的前缀和，那么从firstIndex+1到i的子数组和一定是0！
            if (map.containsKey(sum)) {
                int firstIndex = map.get(sum);
                if (i - firstIndex > maxLen) {
                    maxLen = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (maxLen == 0) {
            return new String[0];
        } else {
            return Arrays.copyOfRange(array, startIndex, startIndex + maxLen);
        }
    }
}
