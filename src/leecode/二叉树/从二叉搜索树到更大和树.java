package leecode.二叉树;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 二叉搜索树中序遍历得到的就是递增的序列，如果反向中序遍历得到的就是递减序列，
 * 同时在遍历过程中累加遇到的每个结点值，就是当前结点更大和树的值！
 *
 * @date: 2023-12-04 21:00
 */
public class 从二叉搜索树到更大和树 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

}
