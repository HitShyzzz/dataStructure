package leecode.栈;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/21:17
 * @Description:
 */
public class 柱形图中最大的矩形方法2 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5,6,2,3};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }

    /**
     * 在方法1的基础上我们利用数组先把l和r存起来，更新area时，直接拿来用就好了！
     * 这样写还是会超时！
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l = new int[n];
        Arrays.fill(l,-1);
        int[] r = new int[n];
        Arrays.fill(r,n);
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (heights[j] < heights[i]) {
                    r[i] = j;
                    break;
                }
            }
        }
        for (int i = n - 1; i >=0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    l[i] = j;
                    break;
                }
            }
        }
//        for(int i=0;i<n;i++){
//            System.out.print(+l[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<n;i++){
//            System.out.print(+r[i]+" ");
//        }
        for (int i = 0; i < n; i++) {
            area = Math.max(area, (r[i] - l[i] - 1) * heights[i]);
        }
        return area;
    }
}
