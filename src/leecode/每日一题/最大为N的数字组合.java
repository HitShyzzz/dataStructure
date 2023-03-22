package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/18/10:17
 * @Description:
 */
public class 最大为N的数字组合 {
    private static int ans=0;
    public static void main(String[] args) {
        String[] digits = {"1", "4", "9"};
        int n = 1000000000;
        int i = atMostNGivenDigitSet(digits, n);
        System.out.println(i);
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        recur(digits,n,0,new StringBuilder());
        return ans;
    }

    public static void recur(String[]digits,int n,int index,StringBuilder sb){
        if (index==digits.length){
            return;
        }
        for(int i=index;i<digits.length;i++){
            sb.append(digits[i]);
            while (Long.valueOf(sb.toString())<=n){
                sb.append(digits[i]);
                ans++;
            }
        }
        recur(digits,n,index+1,sb);
        recur(digits,n,index+1,sb.append(digits[index]));
        sb.deleteCharAt(sb.length()-1);
    }
}
