package interview.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/20/15:40
 * @Description:
 */
public class 淘汰分数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        if(y==n){
            System.out.println(-1);
        }
        int []nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        Arrays.sort(nums);
//        for(int num :nums){
//            System.out.print(num+" ");
//        }
        int low=Math.max(x,n-1-y);
        int sup=Math.min(y,n-1-x);
        System.out.println(nums[n-1-y]);
    }
}
