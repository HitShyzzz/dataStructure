package leecode.模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/12/22:53
 * @Description:
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] revolve = revolve1(matrix);
        for (int i = 0; i < revolve.length; i++) {
            for (int j = 0; j < revolve[0].length; j++) {
                System.out.print(revolve[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> list = spiralOrder(matrix);
        for (Integer key : list) {
            System.out.print(key + " ");
        }
    }


    // 1 2 3          1 4 7        3 6 9
    // 4 5 6  ------> 2 5 8------->2 5 8
    // 7 8 9          3 6 9        1 4 7
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        while (matrix.length >= 1) {
            for (int num : matrix[0]) {
                ans.add(num);
            }
            matrix = revolve1(matrix);
        }
        return ans;
    }

    // 逆时针旋转矩阵
    public static int[][] revolve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        // 再上下镜像
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = res[i][j];
                res[i][j] = res[n - 1 - i][j];
                res[n - 1 - i][j] = temp;
            }
        }
        return res;
    }

    // 逆时针旋转同时削第一行
    public static int[][] revolve1(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j + 1][n - 1 - i];
            }
        }
        return res;
    }
}
