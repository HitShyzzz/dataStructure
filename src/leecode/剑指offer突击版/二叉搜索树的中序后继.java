package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/9:23
 * @Description:
 */
public class 二叉搜索树的中序后继 {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root);
        TreeNode res = null;
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node = list.get(i);
            if (node.val == p.val) {
                res = list.get(i + 1);
                break;
            }
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

}
