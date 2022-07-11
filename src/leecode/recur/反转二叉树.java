package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/20:06
 * @Description:
 */
public class 反转二叉树 {

    /**
     * 递归写法，反转二叉树，root结点不变，root.left就是反转后的右子树，root.right就是反转后的左子树，
     * 先用个变量把root.left存储起来，避免反转后把原来的子树覆盖了！
     * O(T)=O(n),n是二叉树结点的数目；
     * O(S)=O(n),递归的层数取决于树的深度，最坏情况下，树的深度=结点的数目，此时空间复杂度达到O(n);
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
