package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/19:46
 * @Description:
 */
public class 搜索二维矩阵II方法2 {

    /**
     * Z字形查找，我们从矩阵右上角[0,n-1]开始查找，每次查找的范围是以matrix左下角为左下角，以[x,y]为右上角的矩形区域进行
     * 查找，如果matrix[x][y]>target,那么第y列的元素都会>target,直接将y-1;如果matrix[x][y]<target,那么第x行的所有元素都会
     * ＜target，直接将x+1;
     * O(T)=O(m+n),x最多加m次，y最多减n次，因此总共的搜索次数最多是O(m+n);
     * O(S)=O(1);
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
