package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/20:34
 * @Description:
 */
public class 颜色分类方法3 {
    /**
     * 定义两个指针p0和p1,分别指向0和1；一趟扫描就完事！
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1++);
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {// 这里如果p0<p1,那么就会有1被交换到2的后面去了，这是需要再和p1指针交换一下，才正确！
                    swap(nums, i, p1);
                }
                p0++;
                p1++;// 0排到1的前面去了，那么对应的p1指针也要后移
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
