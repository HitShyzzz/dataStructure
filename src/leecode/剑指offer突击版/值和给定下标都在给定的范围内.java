package leecode.剑指offer突击版;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/9:38
 * @Description:
 */
public class 值和给定下标都在给定的范围内 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            // 大于等于x-t的上确界
            Long sup = set.ceiling((long) nums[i] - (long) t);
            // 只要大于等于x-t最小的那个<=x+t,就一定能找到！
            if (sup != null && sup <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 滑动窗口内元素大于k个，移除最远的那个！
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
