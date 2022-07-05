package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/20:55
 * @Description:
 */
public class 柱形图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }


    /**
     * 这里的关键是要会去计算每个柱子的面积，对于第i个柱子，我们向左需要找到第一个比height[i]低的柱子的下标l，
     * 向右找到第一个比height[i]低的柱子的下标r,那么第i个柱子能围成的矩形的最大面积就是area=(r-l-1)*height[i];
     * 至于优化就是在优化l和r，但核心思想都是不变的！
     * 这是最基本的思路，但这样写的话是过不了的，会超时！
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            int l = -1;
            int r = n;
            for (int j = i; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    l = j;
                    break;
                }
            }
            for (int k = i; k < n; k++) {
                if (heights[k] < heights[i]) {
                    r = k;
                    break;
                }
            }
            area = Math.max(area, (r - l - 1) * heights[i]);
        }
        return area;
    }
}
