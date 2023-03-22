package leecode.recur;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/16:09
 * @Description:
 */
public class 二叉搜索树与双向链表方法2 {
    /**
     * 用栈去实现中序遍历，在遍历的过程中修改指针的指向！
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
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode root = null;
        boolean isRoot = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isRoot) {
                root = cur;
                pre = root;
                isRoot = false;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return root;
    }
}
