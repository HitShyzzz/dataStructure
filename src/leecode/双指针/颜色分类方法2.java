package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/20:18
 * @Description:
 */
public class 颜色分类方法2 {

    /**
     * 单指针，两趟扫描，第一趟扫描把所有的0都交换到头部，并且把头部后移，第二趟扫描从头部开始把所有的1和头部交换，那么此时
     * 剩下的都是2，我们就达到了目的！
     * O(T)=O(n)；
     * O(S)=O(1);
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int ptr = 0;// 记录头部的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr++);
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr++);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
