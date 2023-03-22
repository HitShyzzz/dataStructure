package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/04/10:14
 * @Description:
 */
public class 最接近目标价格的甜点成本 {
    int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // baseCosts = [10], toppingCosts = [1], target = 1---->10
        res = baseCosts[0];// 给res一个初值，否则的话看上面注释的反例；
        // 对于每一个基料去递归判断
        for (int b : baseCosts) {
            dfs(toppingCosts, 0, b, target);
        }
        return res;
    }

    public void dfs(int[] toppingCosts, int index, int curCost, int target) {
        // 如果当前成本已经超出了target，那么再递归下去，curCost只会越累加与target差值越大，因此一旦出现这种情况，
        // 就停下来不再继续向下走了
        if (Math.abs(res - target) < curCost - target) {
            return;
        } else if (Math.abs(res - target) > Math.abs(curCost - target)) {
            res = curCost;
        } else if (Math.abs(res - target) == Math.abs(curCost - target)) {
            res = Math.min(curCost, res);// 尽可能选择成本较低的方案
        }
        if (index == toppingCosts.length) {
            return;
        }
        // 每个配料可以添加0，1，2份
        dfs(toppingCosts, index + 1, curCost, target);
        dfs(toppingCosts, index + 1, curCost + toppingCosts[index], target);
        dfs(toppingCosts, index + 1, curCost + toppingCosts[index] * 2, target);
    }
}
