package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/21:36
 * @Description:
 */
public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }

    // 先前序遍历把结果存起来，再让原二叉树的右指针把前序遍历的结果连接起来，左指针为空
    // O(T)=O(n),需要遍历每个结点；O(S)=O(n)，前序遍历递归空间栈的调用！
    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
