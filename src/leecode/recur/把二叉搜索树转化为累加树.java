package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/18:23
 * @Description:
 */
public class 把二叉搜索树转化为累加树 {
    int sum = 0;

    /**
     * 思路：反向中序遍历，右→根→左！因为二叉搜索树的性质，中序遍历得到的是递增序列，如果反向中序遍历的话，就会得到递减
     * 序列，在遍历过程中不断累加根节点的值，就能得到二叉搜索树！
     * O(T)=O(n);需要遍历二叉树的所有结点，
     * O(S)=O(n);空间复杂度来自递归空间栈的调用！
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
