package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/10/9:14
 * @Description:
 */
public class 修建二叉搜索树方法2 {
    // 迭代写法，就是模拟，一一去遍历
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else if (root.val > high) {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur.left != null) {
            if (cur.left.val < low) {
                cur.left = cur.left.right;
            } else {// cur.left.val>=low,那么整个右子树都会>=low
                cur = cur.left;
            }
        }
        cur = root;
        while (cur.right != null) {
            if (cur.right.val > high) {
                cur.right = cur.right.left;
            } else {// cur.right.val<=high,整个左子树都会<=high
                cur = cur.right;
            }
        }
        return root;
    }
}
