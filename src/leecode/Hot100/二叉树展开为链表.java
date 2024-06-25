package leecode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-25 21:53
 */
public class 二叉树展开为链表 {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        dfs(root);
        TreeNode cur = root;
        for (TreeNode node : list) {
            cur.left = null;
            cur.right = node;
            cur = cur.right;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
