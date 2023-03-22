package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/22:34
 * @Description:
 */
public class 合并二叉树 {
    /**
     * 递归的合并，每个结点的值=二叉树1对应结点值+二叉树2对应结点值；如果有一个树对应位置为空，那么就直接返回另一个树对应的位置的结点就好了！
     * O(T)=O(min(m,n)),当有一棵树为空时，就直接把另一颗树剩下的部分添加进来了，因此时间复杂度不会超过min(m,n);
     * O(S)=O(min(m,n))，空间复杂度主要来自递归空间栈的调用！递归的深度不会超过矮的那课树的深度，最坏情况下树的深度=树的高度！
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
}
