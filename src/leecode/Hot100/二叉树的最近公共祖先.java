package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 16:02
 */
public class 二叉树的最近公共祖先 {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getRoot(root);
        while (p != null) {
            visited.add(p);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    // 存储每个节点的父节点
    public void getRoot(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            getRoot(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            getRoot(root.right);
        }
    }
}
