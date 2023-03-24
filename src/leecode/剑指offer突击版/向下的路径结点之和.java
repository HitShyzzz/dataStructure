package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/17:56
 * @Description:
 */
public class 向下的路径结点之和 {
    /**
     *
     * @param root
     * @param targetSum
     * @return 以root为根节点，和为targetSum的路径之和，root为根结点，不一定要从root出发！
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    /**
     *
     * @param root
     * @param sum
     * @return 从root出发向下，和为sum的路径之和
     */
    public int dfs(TreeNode root, long sum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == sum) {
            res++;
        }
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }
}
