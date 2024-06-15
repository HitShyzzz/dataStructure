package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-13 22:24
 */
public class 打家劫舍III {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // 返回的是，选择root节点和不选择root节点能获得的最大金额数
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int selected = root.val + left[1] + right[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, notSelected};
    }
}
