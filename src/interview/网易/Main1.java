package interview.网易;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/04/15:09
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        String[] s = s1.split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        int[]nums=new int[n];
        String[]str=s2.split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<(nums[n-1]-nums[i])/k;j++){
                if (map.containsKey(nums[i]+k*(j+1))){
                    map.put(nums[i]+k*(j+1),map.get(nums[i]+k*(j+1))+1);
                }
            }
        }
        int ans=0;
        for(Integer key:map.keySet()){
            ans=Math.max(ans,map.get(key));
        }
        System.out.println(ans);
    }
}
