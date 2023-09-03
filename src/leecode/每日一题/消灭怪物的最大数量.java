package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/09/03/20:38
 * @Description:
 */
public class 消灭怪物的最大数量 {
    public static void main(String[] args) {
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};
        int i = eliminateMaximum(dist, speed);
        System.out.println(i);
    }

    // 输入：dist = [3,2,4], speed = [5,3,2]
    //输出：1
    //解释：
    // 第 0 分钟开始时，怪物的距离是 [3,2,4]，你消灭了第一个怪物。
    // 第 1 分钟开始时，怪物的距离是 [X,0,2]，你输掉了游戏。
    // 你只能消灭 1 个怪物。

    /**
     * @param dist
     * @param speed
     * @return int
     * @Author Shy
     * @Description 优先攻击先到的怪物 贪心！
     * @Date 2023/9/3 21:41
     **/
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivedTime = new int[n];
        for (int i = 0; i < n; i++) {
            // 向上取整太牛了！向上取整是从Java18开始有的！！
            //arrivedTime[i] = Math.ceilDiv(dist[i], speed[i]);
            arrivedTime[i] = (dist[i] % speed[i] == 0 ? 0 : 1) + dist[i] / speed[i];
        }
        // 优先攻击先到的怪物
        Arrays.sort(arrivedTime);
        for (int i = 0; i < n; i++) {
            // 如果怪物先到或者恰好这一分钟之内到，我们就结束了！
            if (arrivedTime[i] <= i) {
                return i;
            }
        }
        // 没有怪物到达时间比我攻击早到的，就能消灭全部的怪物！
        return n;
    }
}
