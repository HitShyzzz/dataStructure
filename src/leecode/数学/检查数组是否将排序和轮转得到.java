package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/27/10:33
 * @Description:
 */
public class 检查数组是否将排序和轮转得到 {
    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
