package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/8:43
 * @Description:
 */
public class 节点之和最大的路径 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // root结点的最大贡献值
    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子节点最大贡献值，如果是负数，贡献值就是0
        int l = Math.max(maxGain(root.left), 0);
        // 右子节点最大贡献值，如果是负数，贡献值就是0
        int r = Math.max(maxGain(root.right), 0);
        // root节点对于maxSum的贡献值
        int price = l + r + root.val;
        maxSum = Math.max(maxSum, price);
        return root.val + Math.max(l, r);
    }
}
