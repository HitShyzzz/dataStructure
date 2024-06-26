package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-26 20:53
 */
public class 二叉树的最大深度 {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            if (depth > ans) ans = depth;
            return;
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
