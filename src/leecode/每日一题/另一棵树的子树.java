package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 12:33
 */
public class 另一棵树的子树 {
    List<TreeNode> list = new ArrayList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 前序遍历得到root为根的树的全部结点
        dfs(root);
        // 一一遍历root为根的树的全部节点
        for (TreeNode node : list) {
            // 只要根结点值相等，就比较两棵树是否完全相等
            if (node.val == subRoot.val) {
                if (isEqual(node, subRoot)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    public boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        if (root1.val != root2.val) return false;
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }
}
