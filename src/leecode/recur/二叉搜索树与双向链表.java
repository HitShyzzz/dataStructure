package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/15:48
 * @Description:
 */
public class 二叉搜索树与双向链表 {
    public List<TreeNode> list = new ArrayList<>();

    /**
     * 因为二叉搜索树的特点，中序遍历二叉树得到的结点一定是升序排列的，因此只要用一个数组来记录中序遍历的结果，
     * 然后再把左指针指向前驱节点，右指针指向后继结点就好了！
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inorder(pRootOfTree);
        for (int i = 0; i + 1 < list.size(); i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
