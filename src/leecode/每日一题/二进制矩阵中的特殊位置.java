package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/9:17
 * @Description:
 */
public class 二进制矩阵中的特殊位置 {
    public static void main(String[] args) {
        int[][]mat={{1,0,0},{0,1,0},{0,0,1}};
        int i = numSpecial(mat);
        System.out.println(i);
    }
    public static int numSpecial(int[][] mat) {
        Map<Integer,Integer> rows=new HashMap<>();
        Map<Integer,Integer>cols=new HashMap<>();
        int m= mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (mat[i][j]==1){
                    rows.put(i,rows.getOrDefault(i,0)+1);
                    cols.put(j,cols.getOrDefault(j,0)+1);
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (mat[i][j]==1&&rows.get(i)==1&&cols.get(j)==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
