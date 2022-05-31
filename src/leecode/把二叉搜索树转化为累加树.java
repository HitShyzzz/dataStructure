package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/03/13:24
 * @Description:
 */
public class 把二叉搜索树转化为累加树 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
