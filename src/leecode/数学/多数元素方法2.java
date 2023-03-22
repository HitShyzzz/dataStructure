package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/17:37
 * @Description:
 */
public class 多数元素方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 投票算法；如果candidate没有最多的票数maj,那么maj和其他的非候选人会一起来反对candidate，直到candidate下台，
     * 当candidate的票数减到0时发生换届，如果candidate有最多的票数maj,maj自己会支持自己，虽然其他竞争者会反对，但由于candidate的票数最多
     * ，过半了，因此candidate一定会当选！
     * O(T)=O(n);只需要一次遍历数组
     * O(S)=O(1);常数空间
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;// 记录票数
        for (int num : nums) {
            if (count == 0) {// 票数为0了，要换届了！
                candidate = num;
            }
            count += (candidate == num ? 1 : -1);
        }
        return candidate;
    }
}
