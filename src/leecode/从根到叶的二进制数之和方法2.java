package leecode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/30/15:14
 * @Description:
 */
public class 从根到叶的二进制数之和方法2 {
    public int sumRootToLeaf(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int val = 0;// 用来记录中间的结果
        int ans = 0;// 用来记录最终结果
        TreeNode prev = null;// 记录上一轮访问过的节点，只记录右节点的部分
        while (root != null || !stack.isEmpty()) {
            // 先遍历左子节点
            while (root != null) {
                val = val << 1 | root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            // 右子节点为空或者右子节点等于上一轮访问过的节点，说明此时这个节点的左子节点和右子节点都已经访问过了；
            if (root.right == null || root.right == prev) {
                // 叶子节点
                if (root.left == null && root.right == null) {
                    ans += val;
                }
                stack.pop();
                val /= 2;// 最后节点左左子节点已经为空了，还是×了2，所以要除以2；
                prev = root;
                root = null;
            } else {// 右子节点没有访问
                root = root.right;
            }
        }
        return ans;
    }
}
