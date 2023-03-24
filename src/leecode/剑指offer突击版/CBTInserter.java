package leecode.剑指offer突击版;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/12:22
 * @Description:
 */
public class CBTInserter {
    public TreeNode root;
    public Queue<TreeNode> candidate;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.candidate = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            // 未满的结点
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode cur = candidate.peek();
        if (cur.left == null) {
            cur.left = node;
        } else {
            cur.right = node;
            candidate.poll();
        }
        candidate.offer(node);
        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
