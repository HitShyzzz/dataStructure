package leecode.Hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 16:20
 */
public class 合并二叉树方法2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left != null || node2.left != null) {
                if (node1.left != null && node2.left != null) {
                    node.left = new TreeNode(node1.left.val + node2.left.val);
                    queue.offer(node.left);
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                } else if (node1.left != null) {
                    node.left = node1.left;
                } else if (node2.left != null) {
                    node.left = node2.left;
                }
            }
            if (node1.right != null || node2.right != null) {
                if (node1.right != null && node2.right != null) {
                    node.right = new TreeNode(node1.right.val + node2.right.val);
                    queue.offer(node.right);
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                } else if (node1.right != null) {
                    node.right = node1.right;
                } else if (node2.right != null) {
                    node.right = node2.right;
                }
            }
        }
        return root;
    }
}
