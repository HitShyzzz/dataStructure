package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/10:09
 * @Description:
 */
public class 所有大于等于结点的值之和 {
    int sum = 0;

    /**
     * 根据二叉搜索树的特点，中序遍历二叉搜索树一定是单调递增的，如果我们反向中序遍历，即right-》root-》left，
     * 那么得到的序列一定是单调递减的，我们只要在遍历的过程中去累加已经遍历过结点的值即可；
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;// 累加遍历过的结点值
            root.val = sum;// 修改当前结点值为累加值
            convertBST(root.left);
        }
        return root;
    }
}
