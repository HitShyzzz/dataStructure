package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-27 20:40
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
//        root.left=new TreeNode(2);
        root.right = new TreeNode(2147483647);
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
        System.out.println(Integer.MAX_VALUE);
    }

    //
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    // sup表示以root为根结点的上限，inf表示以root为根结点树的下限
    public static boolean dfs(TreeNode root, long sup, long inf) {
        if (root == null) return true;
        // root结点值在上下限之外，就是false
        if (root.val >= sup || root.val <= inf) return false;
        // 左子树上限是root.val
        boolean l = dfs(root.left, root.val, inf);
        // 右子树下限是root.val
        boolean r = dfs(root.right, sup, root.val);
        return l && r;
    }
}
