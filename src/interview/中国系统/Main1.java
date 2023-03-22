package interview.中国系统;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/30/14:22
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        // 去掉开头的[和结尾的]
        String s1=s.substring(1,s.length()-1);
        //System.out.println(s1);// 5, 3, 17, 6, 8, 1, 14
        String[]str=s1.split(", ");
        int[]nums=new int[str.length];
        for(int i=0;i< nums.length;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(nums);
        System.out.print("[");
        for(int i=0;i< nums.length-1;i++){
            System.out.print(nums[i]+", ");
        }
        System.out.print(nums[nums.length-1]+"]");
    }
}
