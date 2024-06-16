package leecode.Hot100;


/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 16:02
 */
public class 二叉树的最近公共祖先方法2 {

    public TreeNode ans = new TreeNode(-1);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // 返回以root为根节点的子树是否包含p节点或者q节点
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if (lson && rson || (root.val == p.val || root.val == q.val && (lson || rson))) ans = root;
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
