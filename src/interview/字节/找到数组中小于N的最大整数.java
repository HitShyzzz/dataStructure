package interview.字节;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * 字节面试题，数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。
 * 例如A={1, 2, 4, 9}，x=2533，返回2499
 *
 * @Author: shy
 * @Date: 2022/07/27/17:12
 * @Description:
 */
public class 找到数组中小于N的最大整数 {
    public static void main(String[] args) {
        int[] A = {1,2,4,9};
        int x = 2533;
        int i = maxNum(A, x);
        System.out.println(i);
    }

    private static int ans = 0;

    //传入 数组A 和 x
    public static int maxNum(int[] A, int x) {
        dfs(A,x,0,0);
        return ans;
    }

    /**
     * 递归的去添加A中的所有元素，如果添加的结果小于x，就去更新结果为所有小于x的最大值！
     *
     * @param x
     * @return
     */
    public static void dfs(int[] A, int x, int index, int cur) {
        if (cur >= x || index == A.length) {
            return;
        }
        ans = Math.max(ans, cur);
        // 添加当前元素
        dfs(A, x, index, cur * 10 + A[index]);
        // 回溯
        cur = (cur - A[index]) / 10;
        dfs(A, x, index + 1, cur);

    }
}
