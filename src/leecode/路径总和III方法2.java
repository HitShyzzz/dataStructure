package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/27/10:40
 * @Description:
 */
public class 路径总和III方法2 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> prefix = new HashMap<>();// 存的是从根节点到当前节点中满足和为target的数量
        prefix.put(0L, 1);// 这是为了处理从根节点到当前节点中，单个节点就等于target的情况；此时cur-target==0;
        return dfs(root, prefix, 0L, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, Long cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        cur += root.val;// cur存的是从根节点到当前节点的和，即前缀和
        int path = 0;//
        path = prefix.getOrDefault(cur-targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        path += dfs(root.left, prefix, cur, targetSum);
        path += dfs(root.right, prefix, cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return path;
    }
}
