package leecode.模拟;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/11:13
 * @Description:
 */
public class 最长连续序列方法2 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 3, 0, -1, 4, 6, 5, 8, 7, 9};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    /**
     * 当前元素cur能构成的最长连续序列长度=cur-1能构成的最长连续序列长度+(cur+1能构成的最长连续序列长度)+1.
     * 这里涉及到cur右侧的元素了，所以不同于以往动态规划的写法，利用hashMap来写；
     * 比如234 678，cur=5;那cur-1=4能构成的最长连续序列长度就是3,cur+1=6能构成的最长连续序列长度也是3，那么
     * cur能构成的最长连续序列长度就是3+1+3=7;同时更新左侧5-3=2能构成的最长连续序列长度为7，更新右侧5+3=8能构成的
     * 最长连续序列长度也为7！
     * O(T)=O(n);每个点都需要遍历一遍！
     * O(S)=O(n);需要利用HashMap来存储每个元素能构造的最长连续序列长度！
     *
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        // 存储当前元素cur能构成的最长连续序列长度；
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 已经存到hashMap里的元素再遇到了就要跳过！
            if (!map.containsKey(num)) {
                // cur-1能构成的最长连续序列长度
                int left = map.getOrDefault(num - 1, 0);
                // cur+1能构成的最长连续序列长度
                int right = map.getOrDefault(num + 1, 0);
                int curLen = left + right + 1;// cur能构成的最长连续序列长度=left+right+1;
                if (curLen > ans) {
                    ans = curLen;
                }
                // map.put(num, curLen)这句话其实只是为了标记一下说cur元素已经被访问了，下次跳过就好了，cur不在端点上，
                // 所以这里num的value值可以随意写，
                map.put(num, curLen);
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }
}
