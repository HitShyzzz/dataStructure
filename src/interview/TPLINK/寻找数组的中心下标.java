package interview.TPLINK;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/19/16:26
 * @Description:
 */
public class 寻找数组的中心下标 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = pivotIndex(nums);
        System.out.println(i);
    }

    // nums = [1, 7, 3, 6, 5, 6]-----》3
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += nums[i];
            if (temp == sum - temp + nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
