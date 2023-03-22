package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/02/22:39
 * @Description:
 */
public class 最长同值路径 {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * @param root 以root为根节点的二叉树
     * @return 从root结点向左右两边扩展的最长等值边数
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);// 左子树能向两边扩展的最长等值边数
        int right = dfs(root.right);// 右子树能向两边扩展的最长等值边数
        int extraLeft = 0;// 当前结点能向左边扩展的最长等值边数
        int extraRight = 0;// 当前结点能向右边扩展的最长等值边数
        if (root.left != null && (root.val == root.left.val)) {
            extraLeft = left + 1;// 当前结点和左子结点相等，那么就能把左子结点扩展的最长等值边数连接起来
        }
        if (root.right != null && (root.val == root.right.val)) {
            extraRight = right + 1;// 当前结点和右子结点相等，那么就能把右子结点扩展的最长等值边数连接起来
        }
        ans = Math.max(ans, extraLeft + extraRight);// 对于每个结点能扩展的最长等值边数=左边能扩展的最长边数+右边能扩展的最长边数！
        return Math.max(extraLeft, extraRight);// 每个结点能向左右两边扩展的最长等值边数应该是两者的较大值！
    }
}
