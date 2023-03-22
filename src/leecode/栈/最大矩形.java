package leecode.栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/23:12
 * @Description:
 */
public class 最大矩形 {
    public static void main(String[] args) {
        char[][]matrix={{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);

    }
    /**
     *这道题跟柱形图最大矩形思路类似，还是要先去找关键点；我们需要先维护矩阵l[i][j]表示matrix[i][j]左侧连续1的数量，（包括matrix[i][i]）
     * 那么矩形的宽是当前行上面l[i][j]的最小值设为第k行，那么area=width*(i-k+1);
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // 首先维护l[i][j]矩阵
        int[][]l=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    l[i][j]=(j==0?1:l[i][j-1]+1);
                }
            }
        }
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    continue;
                }
                int width=l[i][j];
                int area=width;
                for(int k=i-1;k>=0;k--){
                    if(matrix[k][j]=='0'){
                        break;
                    }
                    width = Math.min(width, l[k][j]);
                    area=Math.max(area,(i-k+1)*width);
                }
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}
