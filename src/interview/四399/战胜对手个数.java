package interview.四399;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/15/21:52
 * @Description:
 */
public class 战胜对手个数 {
    public static void main(String[] args) {

    }
    public static int cntOfWin(int[]A,int[]B,int p,int e){
        Arrays.sort(A);
        Arrays.sort(B);
        int m=A.length;
        int n=B.length;
        int cnt=0;
        if (A[m-1]<B[0]){
            return m;
        } else if (B[n-1]<A[0]) {
            for(int i=n-1;i>=n-p;i--){
                B[i]+=e;
                for(int j=0;j<m;j++){
                    if (B[i]>A[j]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
