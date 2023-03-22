package interview.美团;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/08/16:38
 * @Description:
 */
public class 连续和为n的数 {
    public static void main(String[] args) {
        int n=15;
        List<List<Integer>> lists = solution(15);
        for(List<Integer> list:lists){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> solution(int n){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
            List<Integer>list=new ArrayList<>();
            if ((Math.sqrt(1+4*(Math.pow(i,2)-i+2*n))-1)%2==0){
                int y=(int)(Math.sqrt(1+4*(Math.pow(i,2)-i+2*n))-1)/2;
                for(int j=i;j<=y;j++){
                    list.add(j);
                }
            }
            ans.add(list);
        }
        return ans;
    }

}
