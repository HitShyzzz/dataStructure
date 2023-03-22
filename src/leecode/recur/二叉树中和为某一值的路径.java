package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/15:42
 * @Description:
 */
public class 二叉树中和为某一值的路径 {
    /**
     * 求的是是否有从根节点到叶子结点的路径之和等于target，理解清楚题意；
     * O(T)=O(n);
     * O(S)=O(height);最坏情况下树的高度height==节点数n;
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        sum -= root.val;
        // 从根节点到叶子结点的结点值之和。。。
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
