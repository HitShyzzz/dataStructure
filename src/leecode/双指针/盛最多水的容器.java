package leecode.双指针;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/20/20:18
 * @Description:
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 初始时，左指针l=0，右指针r=n-1,area=Math.min(h[l],h[r])*(r-l),我们每次移动h[l]和h[r]二者较小者对应的指针，
     * 同时动态更新面积，直到两个指针相遇，面积的最大值就是最终结果
     * O(T)=O(n)，每个元素最多遍历一次，
     * O(S)=O(1);
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int l = 0;// 左指针
        int r = n - 1;// 右指针
        int MaxArea = 0;
        int area = 0;
        while (l <= r) {
            area = Math.min(height[l], height[r]) * (r - l);
            MaxArea = Math.max(MaxArea, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return MaxArea;
    }
}
