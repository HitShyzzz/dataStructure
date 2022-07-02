package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/20:16
 * @Description:
 */
public class 颜色分类 {
    /**
     * 这个思路就是先去统计0的个数，1的个数，和2的个数，那么最终一定是最前面是0，中间是1，最后是2；
     * O(T)=O(n);
     * O(S)=O(1);
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int countOf0 = 0;
        int countOf1 = 0;
        for (int num : nums) {
            if (num == 0) {
                countOf0++;
            }
            if (num == 1) {
                countOf1++;
            }
        }
        for (int i = 0; i < countOf0; i++) {
            nums[i] = 0;
        }
        for (int i = countOf0; i < countOf0 + countOf1; i++) {
            nums[i] = 1;
        }
        for (int i = countOf0 + countOf1; i < n; i++) {
            nums[i] = 2;
        }
    }
}
