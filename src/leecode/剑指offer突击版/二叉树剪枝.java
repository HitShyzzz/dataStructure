package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/16:39
 * @Description:
 */
public class 二叉树剪枝 {
    /**
     * @param root 二叉树的根节点
     * @return 以root为根节点的二叉树剪枝后的头结点
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左子结点=剪枝后的左子结点
        root.left = pruneTree(root.left);
        // 右子结点-=剪枝后的右子结点
        root.right = pruneTree(root.right);
        // 只有当前为0，且剪枝后的左子结点为空同时右子结点为空，当前结点就可以删除了！！
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
