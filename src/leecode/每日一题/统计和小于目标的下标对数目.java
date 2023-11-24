package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-24 21:58
 */
public class 统计和小于目标的下标对数目 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        int target = 2;
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        int i = countPairs1(nums, target);
        System.out.println(i);
    }

    // 输入：nums = [-1,1,2,3,1], target = 2
    // 输出：3
    // 解释：总共有 3 个下标对满足题目描述：
    //- (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
    //- (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target
    //- (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
    //注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target
    public static int countPairs(List<Integer> nums, int target) {
        int res = 0;
        Collections.sort(nums);
        if (nums.get(0) + nums.get(1) >= target) {
            return res;
        }
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums.get(i) + nums.get(i + 1) >= target) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static int countPairs1(List<Integer> nums, int target) {
        int res = 0;
        Collections.sort(nums);
        if (nums.get(0) + nums.get(1) >= target) {
            return res;
        }
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int index = binarySearch(nums, 0, i - 1, target - nums.get(i));
            res += index;
        }
        return res;
    }

    /**
     * @description:
     * @author: shy
     * @date: 2023/11/24 22:23
     * @param:
     * @param: nums
     * @param: start
     * @param: target
     * @return: int  nums[i]+nums[j]>=target的最小下标
     **/
    public static int binarySearch(List<Integer> nums, int l, int r, int target) {
        int index = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums.get(mid) >= target) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
