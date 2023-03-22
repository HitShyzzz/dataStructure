package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/02/13:27
 * @Description:
 */
public class 删除二叉查找树的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {// 要删除的key是root节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 要删除的根节点左右子节点都不为空
            TreeNode t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    // 找到以x为根节点的最小键
    public TreeNode min(TreeNode x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    // 删除以x为根节点的最小键
    public TreeNode deleteMin(TreeNode x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
}


