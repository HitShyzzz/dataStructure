package interview.网易;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/16:29
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String s1=in.nextLine();
        String[]ss=s.split(" ");
        int n=Integer.parseInt(ss[0]);
        int k=Integer.parseInt(ss[1]);
        int x=Integer.parseInt(ss[2]);
        String[]str=s1.split(" ");
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        int i = solution(nums, n, k, x);
        System.out.println(i);
    }
    public static int solution(int[]nums, int n,int k,int x){
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
        }
        int count=0;
        int ans=0;
        while (!pq.isEmpty()){
            int cur=pq.poll();
            if (count<k){
                while (!pq.isEmpty()&&cur>=pq.peek()){
                    cur=cur-x;
                    count++;
                }
            }
            if (count==k&&!pq.isEmpty()){
                ans=pq.peek();
                break;
            }
        }
        return ans;
    }
}
