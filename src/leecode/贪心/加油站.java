package leecode.贪心;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/17/16:00
 * @Description:
 */
public class 加油站 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    // 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // 输出: 3
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;// 记录已经走过的节点数
            while (cnt < n) {
                int nex = (i + cnt) % n;
                sumOfGas += gas[nex];
                sumOfCost += cost[nex];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {// 否则就走到下一个不能到达的位置，i+cnt是目前能达到的最远位置，再加1就是下一个不能达到的位置
                i = i + cnt + 1;
            }


        }
        return -1;
    }
}
