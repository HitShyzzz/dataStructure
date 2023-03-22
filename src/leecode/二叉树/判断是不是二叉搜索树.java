package leecode.二叉树;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/22/10:51
 * @Description:
 */
public class 判断是不是二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        // write code here
        return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**
     * @param root  二叉树的根节点
     * @param upper 左子树的上界
     * @param lower 右子树的下界
     * @return 以root为根结点的子树是否为搜索二叉树
     */
    public boolean check(TreeNode root, int upper, int lower) {
        if (root == null) {
            return true;
        }
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        return check(root.left, root.val, lower) && check(root.right, upper, root.val);
    }
}
