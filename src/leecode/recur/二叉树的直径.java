package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/18:40
 * @Description:
 */
public class 二叉树的直径 {
    int ans = 0;// 表示从一个结点到另一个结点经过的最多的节点数=当前结点左子树的深度+当前结点右子树的深度+1；

    /**
     * 直径=从一个结点到另一个结点经过的最多的节点数-1；
     * O(T)=O(n);n是二叉树结点的数目，
     * O(S)=O(height);height是二叉树的高度，在求树的深度时，显然递归的深度取决于树的高度！
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    /**
     * @param root
     * @return root结点的深度
     */
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
