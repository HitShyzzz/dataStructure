package leecode.recur;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/05/11:07
 * @Description:
 */
public class 二叉树的中序遍历 {

    private static List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历，左，根，右！
     *O(T)=O(n),每个结点需要遍历且只会遍历一次
     * O(S)=O(n),递归空间栈的调用！
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return list;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        recur(root.left);
        list.add(root.val);
        recur(root.right);
    }
}
