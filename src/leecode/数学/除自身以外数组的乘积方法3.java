package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/22:18
 * @Description:
 */
public class 除自身以外数组的乘积方法3 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ints = productExceptSelf(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 在方法2的基础上利用滚动数组的思想把空间复杂度优化到O(1)；
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        // 先把ans[i]定义成nums[i]左侧元素的乘积
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;// R表示nums[i]右侧元素的乘积
        // 再从右侧动态的去乘上R，就行了
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
}
