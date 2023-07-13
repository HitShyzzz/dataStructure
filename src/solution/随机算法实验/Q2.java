package solution.随机算法实验;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/05/31/2:37
 * @Description:
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    static double A[][];
    static double b[];
    static double x[];

    static int n; // n表示未知数的个数
    static int n_2; // 记录换行的次数

    public static void main(String[] args) {

        while (true) {
            System.out.println("请输入数字选择计算方法：\n1.Gauss 2.LineGuess 3.LU 0.退出");
            @SuppressWarnings("resource")
            Scanner sn = new Scanner(System.in);
            int c = sn.nextInt();
            System.out.println("--------------输入方程组未知数的个数---------------");
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            A = new double[n][n];
            b = new double[n];
            x = new double[n];

            System.out.println("--------------输入方程组的系数矩阵A:---------------");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = sc.nextDouble();
                }
            }

            System.out.println("--------------输入方程组的常量向量b:---------------");
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextDouble();
            }
            if (1 == c) {
                Gauss();
            } else if (2 == c) {
                LineGuess();
            } else if (3 == c) {
                LU();
            } else if (0 == c) {
                System.out.println("Bye!");
                System.exit(0);
            }

        }
    }

    // 1
    public static void Gauss() {
        Elimination();
        BackSubstitution();
        PrintRoot();
    }

    // 2
    public static void LineGuess() {
        Elimination2();
        BackSubstitution();
        PrintRoot();
    }

    // 3
    public static void LU() {
        double[] x = solve(A, b);
        System.out.println("结果为：");
        for (int z = 0; z < x.length; z++) {
            System.out.println("X" + z + " = " + x[z]);
        }
    }

    // 高斯
    public static void Elimination() {
        PrintA();
        for (int k = 0; k < n; ) {
            for (int i = k + 1; i < n; i++) {
                double l = A[i][k] / A[k][k];
                A[i][k] = 0;

                for (int j = k + 1; j < n; j++) {
                    A[i][j] = A[i][j] - l * A[k][j];
                }
                b[i] = b[i] - l * b[k];
            }
            System.out.println("第" + ++k + "次消元后:");
            PrintA();
        }
    }

    // 列主元
    public static void Elimination2() {
        PrintA();
        for (int k = 0; k < n; ) {
            WrapRow(k);
            for (int i = k + 1; i < n; i++) {
                double l = A[i][k] / A[k][k];
                A[i][k] = 0;

                for (int j = k + 1; j < n; j++) {
                    A[i][j] = A[i][j] - l * A[k][j];
                }
                b[i] = b[i] - l * b[k];
            }
            System.out.println("第" + ++k + "次消元后:");
            PrintA();
        }
    }

    // 交换矩阵的行
    public static void WrapRow(int k) { // k表示第k+1轮消元
        double max = Math.abs(A[k][k]);
        int Line = k; // 记住要交换的行
        for (int i = k + 1; i < n; i++) {
            if (Math.abs(A[i][k]) > max) {
                Line = i;
                max = A[i][k];
                break;
            }
        }
        if (Line != k) { // 交换求得最大主元
            n_2 += 1;
            System.out.println("k = " + k + "时，" + "要交换的行为" + k + "和" + Line);
            // 先交换A
            for (int j = k; j < n; j++) {
                double[] arr = {A[k][j], A[Line][j]};
                Swap(arr, 0, 1);
                A[k][j] = arr[0];
                A[Line][j] = arr[1];

            }
            // 再交换b
            double[] arr = {b[k], b[Line]};
            Swap(arr, 0, 1);
            b[k] = arr[0];
            b[Line] = arr[1];
            System.out.println("--------------交换后---------------");
            PrintA();
        }
    }

    // 交换Swap函数
    public static void Swap(double[] ar, int x, int y) {
        Double tmp = ar[x];
        ar[x] = ar[y];
        ar[y] = tmp;
    }

    // 回代法
    public static void BackSubstitution() {
        x[n - 1] = b[n - 1] / A[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            x[i] = (b[i] - solve(i)) / A[i][i];
        }
    }

    public static double solve(int i) {
        double result = 0.0;
        for (int j = i; j < n; j++)
            result += A[i][j] * x[j];
        return result;
    }

    // 输出方程组的根
    public static void PrintRoot() {
        System.out.println("--------------方程组的根为---------------");
        for (int i = 0; i < n; i++) {
            System.out.println("X" + i + " = " + x[i]);
        }
    }

    // 输出A的增广矩阵
    public static void PrintA() {
        System.out.println("--------------增广矩阵---------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(+A[i][j] + "  ");
            }
            System.out.println(b[i]);
        }
    }

    // LU
    public static double[] solve(double[][] a, double[] b) {
        List<double[][]> LAndU = decomposition(a); // LU decomposition
        double[][] L = LAndU.get(0);
        double[][] U = LAndU.get(1);
        double[] UMultiX = getUMultiX(a, b, L); // 前代
        return getSolution(a, U, UMultiX); // 回代
    }

    private static double[] getSolution(double[][] a, double[][] U, double[] UMultiX) {
        double[] solutions = new double[a[0].length];
        for (int i = U.length - 1; i >= 0; i--) {
            double right_hand = UMultiX[i];
            for (int j = U.length - 1; j > i; j--) {
                right_hand -= U[i][j] * solutions[j];
            }
            solutions[i] = right_hand / U[i][i];
        }
        return solutions;
    }

    private static double[] getUMultiX(double[][] a, double[] b, double[][] L) {
        double[] UMultiX = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double right_hand = b[i];
            for (int j = 0; j < i; j++) {
                right_hand -= L[i][j] * UMultiX[j]; //
            }
            UMultiX[i] = right_hand / L[i][i];
        }
        return UMultiX;
    }

    private static List<double[][]> decomposition(double[][] a) {
        double[][] U = a; // a是要分解的矩阵
        double[][] L = createIndentityMatrix(a.length);

        for (int j = 0; j < a[0].length - 1; j++) {
            if (a[j][j] == 0) {
                throw new IllegalArgumentException("zero pivot encountered.");
            }

            for (int i = j + 1; i < a.length; i++) {
                double mult = a[i][j] / a[j][j];
                for (int k = j; k < a[i].length; k++) {
                    U[i][k] = a[i][k] - a[j][k] * mult;
                    // 得出上三角矩阵U,通过减去矩阵的第一行,第二行,第一行(第二行)得到上三角矩阵
                }
                L[i][j] = mult; // 得到下三角矩阵是得出上三角矩阵的乘积因子
            }
        }
        System.out.println("--------------L矩阵---------------");
        PrintLU(L);
        System.out.println("--------------U矩阵---------------");
        PrintLU(U);
        return Arrays.asList(L, U);

    }

    public static void PrintLU(double[][] z) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(z[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    private static double[][] createIndentityMatrix(int n) {
        double[][] identityMatrix = new double[n][n];
        for (int i = 0; i < identityMatrix.length; i++) {
            for (int j = i; j < identityMatrix[i].length; j++) {
                if (j == i) {
                    if (j == i) {
                        identityMatrix[i][j] = 1;
                    } else {
                        identityMatrix[i][j] = 0;
                    }
                }
            }
        }
        return identityMatrix;
    }

}

