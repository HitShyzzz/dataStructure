package leecode.栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/01/20:51
 * @Description:
 */
public class 商品折扣后的最终价格 {
    public static void main(String[] args) {
        int[]prices={8,4,6,2,3};
        int[] finalPrices = finalPrices(prices);
        for(int i:finalPrices){
            System.out.print(i+" ");
        }
    }
    public static int[] finalPrices(int[] prices) {
        int n= prices.length;
        int[]ans= Arrays.copyOf(prices,n);
        Deque<Integer>stack=new LinkedList<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&prices[i]<prices[stack.peek()]){
                ans[stack.peek()]=prices[stack.peek()]-prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
