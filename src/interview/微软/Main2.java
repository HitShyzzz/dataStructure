package interview.微软;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/26/19:48
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        int []A={7,1,11,8,4,10};
        int M=8;
        System.out.println(solution(A,M));

    }
    public static int solution(int[] A, int M) {
        // write your code in Java 8 (Java SE 8)
        if(A==null||A.length<2){
            return 0;
        }
        int n=A.length;
        Arrays.sort(A);
        int ans=0;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=n-1;j>i;j--){
                if((A[j]-A[i])%M==0){
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
