package interview.网易;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/15:35
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[] s1 = s.split(" ");
        int n=Integer.parseInt(s1[0]);
        int k=Integer.parseInt(s1[1]);
        int t=Integer.parseInt(s1[2]);
        String solution = solution(n, k, t);
        System.out.println(solution);

    }
    public static String solution(int n,int k,int t){
        StringBuilder sb=new StringBuilder();
        if (t+1>k){
            return "-1";
        } else if(t+1==k) {
            for (int i = 0; i < k; i++) {
                sb.append("1");
            }
            if (sb.length() == n) {
                return sb.toString();
            } else if (sb.length() < n) {
                int len=sb.length();
                for (int i = 0; i < n - len; i++) {
                    sb.append("0");
                }
                return sb.toString();
            } else {
                return "-1";
            }
        }else{// t+1<k 5 4 2->11011
            for(int i=0;i<k;i++){
                sb.append("110");
            }
            if (sb.length()==n){
                return sb.toString();
            } else if (sb.length()<n) {
                int len=sb.length();
                for(int i=0;i<n-len;i++){
                    sb.append("0");
                }
                return sb.toString();
            }else{
                int n1=sb.length();
                for(int i=n1-1;i>n-1;i--){
                    sb.deleteCharAt(i);
                }
                // 统计1的个数
                int count=0;
                for(int i=0;i<sb.length();i++){
                    if (sb.charAt(i)=='1'){
                        count++;
                    }
                }
                if (count==k){
                    return sb.toString();
                }else{
                    return "-1";
                }
            }
        }
    }
}
