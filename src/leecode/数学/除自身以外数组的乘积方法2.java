package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/22:06
 * @Description:
 */
public class 除自身以外数组的乘积方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4};
        int[] ints = productExceptSelf(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 对于nums[i],我们定义数组L[i]和R[i],分别表示nums[i]左侧数组的乘积，和nums[i]右侧数组的乘积！
     * L[i]=L[i-1]*nums[i-1];R[i]=R[i+1]*nums[i+1];
     * 那么ans[i]=L[i]*R[i];
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
