package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/8:51
 * @Description:
 */
public class 旋转图像方法2 {
    /**
     * 原地旋转，无需另外开辟空间！
     * 最关键的式子就是m[j][n-1-i]=m[i][j]，也就是原来的第i行变成了第n-1-i列，也就是说现在的第i列是原来的第n-1-i行，但直接这样赋值的话，m[j][n-1-i]位置原来的
     * 元素会被覆盖掉，因此我们需要先用变量temp存储原来的元素，即：
     * temp=m[i][j];
     * m[i][j]=m[n-1-j][i];
     * m[n-1-j][i]=m[n-1-i][n-1-j];
     * m[n-1-i][n-1-j]=m[j][n-1-i];
     * m[j][n-1-i]=temp(m[i][j]);
     * 这四项不断进行循环，每次交换4个位置，当n为偶数时，需要交换n^2/4=(n/2)*(n/2)个位置；当n为奇数时，需要交换（n^2-1）/4=
     * (n-1)/2*(n+1)/2个位置，中心位置元素不需要交换；
     * O(T)=O(n^2);
     * O(S)=O(1);
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
