package solution.随机算法实验;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/05/30/23:28
 * @Description:
 */
public class Cholesky {
    public static void main(String[] args) {
        double[][] A = {{3, 2, 3}, {2, 2, 0}, {3, 0, 12}};
        List<double[][]> list = cholesky(A);
        double[][] L = list.get(0);
        System.out.println("L是：");
        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L.length; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }
        double[][] L1 = list.get(1);
        System.out.println("L^T是：");
        for (int i = 0; i < L1.length; i++) {
            for (int j = 0; j < L1.length; j++) {
                System.out.print(L1[i][j] + " ");
            }
            System.out.println();
        }
        double[] b = {5, 3, 7};
        double[] y = solve(L, b);
        double[] x = solve1(L1, y);
        System.out.println("原方程组的解为：");
        // 得到的解是[ 1.666666666666667,0.0,0.6666666666666679 ],这与方程组的精确解[1,1/2,1/3]有误差
        // 主要原因在于中间计算过程中大量数据精度丢失
        System.out.print("[ ");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + ",");
        }
        System.out.println(x[x.length - 1] + " ]");
    }

    // A=LL^T, A是对称正定

    /**
     * @param A 对称正定矩阵A
     * @return 矩阵Acholeshy分解的结果
     */
    public static List<double[][]> cholesky(double[][] A) {
        List<double[][]> ans = new ArrayList<>();
        int n = A.length;
        double[][] L = new double[n][n];
        L[0][0] = Math.sqrt(A[0][0]);
        // L的第一列
        for (int i = 1; i < n; i++) {
            L[i][0] = A[i][0] * 1.0 / L[0][0];
        }
        // L的第二列到第n-1列
        for (int k = 1; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double sum1 = 0;
                double sum2 = 0;
                for (int r = 0; r <= k - 1; r++) {
                    sum1 += L[k][r] * L[k][r];
                    sum2 += L[i][r] * L[k][r];
                }
                L[k][k] = Math.sqrt(A[k][k] - sum1);
                L[i][k] = (A[i][k] - sum2) / L[k][k];
            }
        }
        double sum = 0;
        // L[n-1][n-1]
        for (int r = 0; r < n - 1; r++) {
            sum += L[n - 1][r] * L[n - 1][r];
        }
        L[n - 1][n - 1] = Math.sqrt(A[n - 1][n - 1] - sum);
        // L^T 满足l1[j][i]=l[i][j]
        double[][] L1 = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                L1[i][j] = L[j][i];
            }
        }
        ans.add(L);
        ans.add(L1);
        return ans;
    }

    // 求解Ly=b
    public static double[] solve(double[][] L, double[] b) {
        int n = b.length;
        double[] y = new double[n];
        y[0] = b[0] * 1.0 / L[0][0];
        for (int k = 1; k < n; k++) {
            int sum = 0;
            for (int r = 0; r <= k - 1; r++) {
                sum += L[k][r] * y[r];
            }
            y[k] = (b[k] - sum) * 1.0 / L[k][k];
        }
        return y;
    }

    // 求解L^Tx=y
    public static double[] solve1(double[][] L1, double[] y) {
        int n = y.length;
        double[] x = new double[n];
        x[n - 1] = y[n - 1] * 1.0 / L1[n - 1][n - 1];
        for (int k = n - 2; k >= 0; k--) {
            double sum = 0;
            for (int r = k; r < n; r++) {
                sum += L1[r][k] * x[r];
            }
            x[k] = (y[k] - sum) * 1.0 / L1[k][k];
        }
        return x;
    }
}
