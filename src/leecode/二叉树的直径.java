package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/04/13:32
 * @Description:
 */
public class 二叉树的直径 {
    int ans = 0;// 表示的是二叉树从一个节点到另一个节点经过的最多的节点数，那么直径=ans-1;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    // 求出当前节点的深度
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);// 求出当前节点经过的最多的节点数，并更新最终结果！
        return Math.max(L, R) + 1;// 当前节点的深度为左右子树深度较大值加1；
    }
}
