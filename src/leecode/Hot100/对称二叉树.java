package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-27 20:16
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    // 判断左子树和右子树是否对称
    public boolean dfs(TreeNode left, TreeNode right) {
        // 左右子树都为空
        if (left == null && right == null) return true;
        // 左右子树之一为空
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
