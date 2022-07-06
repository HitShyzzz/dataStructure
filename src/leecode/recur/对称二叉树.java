package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/16:39
 * @Description:
 */
public class 对称二叉树 {


    /**
     * 对称二叉树的条件：left.val==right.val且left的子树和right的子树也还要是对称二叉树！
     * 那么在判断哪两个元素比较时，我们可以定义指针l和r,发现l向左走时r要向右走，l向右走时l要向左走！
     *O(T)=O(n);
     * O(S)=O(n);
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return valid(root, root);
    }

    /**
     * @param l 左指针
     * @param r 右指针
     * @return
     */
    public boolean valid(TreeNode l, TreeNode r) {
        if (l==null&&r==null) {
            return true;
        }
        if(l==null||r==null){
            return false;
        }
        return l.val==r.val&&valid(l.left,r.right)&&valid(l.right,r.left);
    }
}
