package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/10:24
 * @Description:
 */
public class 二叉搜索树中两个结点之和 {
    List<TreeNode> list = new ArrayList<>();
    // 中序遍历+双指针！
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l).val + list.get(r).val == k) {
                return true;
            } else if (list.get(l).val + list.get(r).val < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
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
