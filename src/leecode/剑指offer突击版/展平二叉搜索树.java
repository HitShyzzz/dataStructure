package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/9:06
 * @Description:
 */
public class 展平二叉搜索树 {
    List<TreeNode> list = new ArrayList<>();
    // 先用集合把中序遍历的结果存起来，然后再把集合中的元素串起来就好！
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        TreeNode head = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        // 记得把集合末尾指针置空！
        list.get(list.size() - 1).right = null;
        list.get(list.size() - 1).left = null;
        return head;
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
