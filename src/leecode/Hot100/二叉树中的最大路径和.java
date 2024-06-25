package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-25 21:09
 */
public class 二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * @description:
     * @return: 以root为根结点，且必须以root为起点的最大路径和
     **/
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 如果左子树结果为负数，就取0，也就是不取左子树的结果
        int left = Math.max(dfs(root.left), 0);
        // 如果右子树结果为负数，就取0，也就是不取右子树的结果
        int right = Math.max(dfs(root.right), 0);
        int curSum = root.val + left + right;
        ans = Math.max(ans, curSum);
        return root.val + Math.max(left, right);
    }

}
