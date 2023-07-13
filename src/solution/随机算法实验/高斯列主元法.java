package solution.随机算法实验;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/05/31/1:18
 * @Description:
 */
public class 高斯列主元法 {
    public static void main(String[] args) {
        double[][] A = {{3, 2, 3}, {2, 2, 0}, {3, 0, 12}};
        double[] b = {5, 3, 7};
        double[] x = solve(A, b);
        System.out.println("方程组的解是：");
        System.out.print("[ ");
        for (int i = 0; i < x.length-1; i++) {
            System.out.print(x[i]+",");
        }
        System.out.print(x[x.length-1]+" ]");
    }

    // 高斯列主元求解线性方程组
    public static double[] solve(double[][] A, double[] b) {
        int n = A.length;
        for (int k = 0; k < n; k++) {
            double max =A[k][k];
            int index = k;
            // 按列选主元
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(A[i][k]) > max) {
                    max = A[i][k];
                    index = i;
                }
            }
            // 交换第k行和第i行
            if (max != 0) {
                if (index != k) {
                    // 矩阵A
                    for (int j = k; j < n; j++) {
                        double temp = A[k][j];
                        A[k][j] = A[index][j];
                        A[index][j] = temp;
                    }
                    // b
                    double temp = b[k];
                    b[k] = b[index];
                    b[index] = b[k];
                }
                // 消元
                for (int i = k + 1; i < n; i++) {
                    double l = A[i][k] / A[k][k];
                    for (int j = k + 1; j < n; j++) {
                        A[i][j] = A[i][j] - l * A[k][j];
                        b[i] = b[i] - l * b[k];
                    }
                }
            }
        }
        // 回代求解
        b[n - 1] = b[n - 1] / A[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * b[j];
            }
            b[i] = (b[i] - sum) / A[i][i];
        }
        return b;
    }
}
