package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 22:42
 */
public class 把二叉搜索树转化为累加树 {
    int sum = 0;

    // 反向中序遍历
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
