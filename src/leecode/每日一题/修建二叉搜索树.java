package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/10/8:39
 * @Description:
 */
public class 修建二叉搜索树 {
    // 递归,DFS
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // root.val<low,则整个左子树都会<low,需要剪掉,返回右子树修建的结果
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {// root.val>high,那么整个右子树都要剪掉，返回左子树修建的结果
            return trimBST(root.left, low, high);
        } else {// root.val在[low,high]
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
