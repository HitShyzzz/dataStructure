package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/23:06
 * @Description:
 */
public class 最长递增子序列方法2 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
     * 贪心+二分查找，我们尽可能的想让递增序列变长，那么我们自然就希望递增序列的最后一个元素尽可能的小，来留出空间让
     * 后面的元素继续添加，因此我们定义数组d[i]表示长度为i的最长递增子序列末尾元素的最小值；
     * if nums[i]<d[len]那就直接添加到数组末尾；
     * 否则我们需要在d数组中进行二分查找，找到第一个比nums[i]小的元素的下标K,并更新d[k+1]=nums[i];在找下标k的时候我们可以进行二分查找来
     * 优化空间复杂度！
     * O(T)=O(nlogn);我们需要遍历所有的元素，每个元素在进行二分查找时时间复杂度是O(logn),因此总的时间复杂度是O(nlogn);
     * O(S)=O(n);需要O(n)的空间存放数组；
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到元素比nums[i]小，那么我们需要更新d[1],因此pos=0;
                int l = 1;
                int r = len;
                int pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
