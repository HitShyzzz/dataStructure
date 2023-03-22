package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/18:38
 * @Description:
 */
public class 二叉树的最大深度 {
    /**
     * 二叉树的最大深度应该是左子树的最大深度和右子树的最大深度两者的较大者再加1；
     * 然后递归的去算左右子树最大深度就好了；
     * O(T)=O(n)；每个结点只会被访问一次；
     * O(S)=O(n);最坏情况下会达到O(n);
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
