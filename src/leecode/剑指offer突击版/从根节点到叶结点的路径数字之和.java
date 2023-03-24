package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/16:54
 * @Description:
 */
public class 从根节点到叶结点的路径数字之和 {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int curSum = sum * 10 + root.val;
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        // 到达叶子结点
        if (root.left == null && root.right == null) {
            ans += curSum;
            return;
        }
    }
}
