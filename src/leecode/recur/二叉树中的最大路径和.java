package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/9:23
 * @Description:
 */
public class 二叉树中的最大路径和 {
    private static int PathSum = Integer.MIN_VALUE;

    /**
     * @param root
     * @return 返回整个二叉树全局的最大路径和，这个最大路径和应该是root.val+以左子树为root结点的最大路径和+
     * 以右子树为root结点的最大路径和
     */
    public static int maxPathSum(TreeNode root) {
        recur(root);
        return PathSum;
    }

    /**
     * O(T)=O(n);每个结点都需要访问到！
     * O(S)=O(n);递归的深度=二叉树的深度，最坏情况下二叉树的深度=树的结点个数，
     *
     * @param root
     * @return 返回以root结点为根节点的最大路径和，这个只是root结点单点的最大路径和！
     */
    public static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = Math.max(recur(root.left), 0);
        int rightPath = Math.max(recur(root.right), 0);
        int curPath = leftPath + rightPath + root.val;
        PathSum = Math.max(PathSum, curPath);// 我们一一的以每个结点为root结点去算出每个结点的最大路径和
        return Math.max(leftPath, rightPath) + root.val;
    }
}
