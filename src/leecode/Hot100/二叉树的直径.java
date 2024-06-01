package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 22:10
 */
public class 二叉树的直径 {
    // 记录以root为根结点的子树经过的最多结点数
    int ans = 0;

    // 直径等于经过的最多结点数-1
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    // 求以root为根结点的深度
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
