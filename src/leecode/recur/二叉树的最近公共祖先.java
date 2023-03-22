package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/21:28
 * @Description:
 */
public class 二叉树的最近公共祖先 {
    /**
     * 最近公共祖先应该满足：首先root是p和q的祖先，但root.left和root.right都不是p和q的祖先；
     * 当前这个函数的作用是返回以root为根节点，p和q的最近公共祖先；
     * 递归的调用这个函数，细节都有注释！
     * O(T)=O(n),n是二叉树结点数目，每个结点只会被访问1次，
     * O(S)=O(n),递归的深度取决于树的深度，最坏情况下树的深度=结点的数目；
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        // 在以root.left为根节点的子树上去找p和q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在以root.right为根节点的子树上去找p和q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果在左子树上没有找到,那么结果只能在右子树上返回的结果
        if (left == null) {
            return right;
        }
        // 如果在右子树上没有找到,那么结果只能在左子树上返回的结果
        if (right == null) {
            return left;
        }
        // 如果在左，右子树上都没有找到结果，那么此时最近公共祖先只能是root结点，即满足root是
        // p和q的祖先，但root.left和root.right都不是p和q的祖先
        return root;
    }
}
