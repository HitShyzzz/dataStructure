package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/15:46
 * @Description:
 */
public class 验证二叉搜素树 {

    /**
     * 二叉搜索树必须满足
     * 左子树上所有结点的值都必须小于root.val;
     * 右子树上所有结点的值都必须大于root.val;
     * 也就是左子树结点的上界是root.val;
     * 右子树结点的下界是root.val;
     * O(T)=O(n);每个结点都需要遍历一次！
     * O(S)=O(n);最坏情况下二叉树是一条链，此时递归最深到n层，最坏情况下的空间复杂度是O(n);
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean valid(TreeNode root, long upper, long lower) {
        if (root == null) {
            return true;
        }
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        if (valid(root.left, root.val, lower) && valid(root.right, upper, root.val)) {
            return true;
        }
        return false;
    }
}
