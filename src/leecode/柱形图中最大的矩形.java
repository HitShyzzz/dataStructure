package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/12/16:24
 * @Description:
 */
public class 柱形图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }

    /**
     * 暴力解法，时间复杂度是O(n^2)，会超时！
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        for (int left = 0; left < n; left++) {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < n; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                res = Math.max(res, minHeight * (right - left + 1));
            }
        }
        return res;
    }
}
