package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/20/13:44
 * @Description:
 */
public class 袋子里最少数目的球 {
    /**
     * 二分查找，我们要找的是一个上界y，使得y<=maxOperations的上确界，即上界的最小值；
     *
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;// 上界初始为nums数组的最大值
        for (int num : nums) {
            if (num > right) {
                right = num;
            }
        }
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;// 总的操作数
            for (int num : nums) {
                ops += (num - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}
