package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/13/20:45
 * @Description:
 */
public class NumArray {
    int[] nums;
    int size;
    int[] sum;// sum[i]表示第i块数组的元素之和

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n % size == 0 ? 0 : 1) + n / size];
        for (int i = 0; i < n; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] = sum[index / size] + val - nums[index];
        nums[index] = val;
    }

    /**
     * @Author Shy
     * @Description  分块求和
     * @Date 2023/11/13 21:28
     * @param left
     * @param right
     * @return int
     **/
    public int sumRange(int left, int right) {
        int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
        int res = 0;
        // left和right在同一块
        if (b1 == b2) {
            for (int i = i1; i <= i2; i++) {
                res += nums[b1 * size + i];
            }
            return res;
        }
        int sum1 = 0, sum2 = 0, sum3 = 0;
        // [i1,size-1]求和
        for (int i = i1; i < size; i++) {
            sum1 += nums[b1 * size + i];
        }
        // [0,i2]求和
        for (int i = 0; i <= i2; i++) {
            sum2 += nums[b2 * size + i];
        }
        // b1+1到b2-1之间的块求和
        for (int i = b1 + 1; i < b2; i++) {
            sum3 += sum[i];
        }
        res = sum1 + sum2 + sum3;
        return res;
    }
}
