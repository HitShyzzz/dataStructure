package leecode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/21:22
 * @Description:
 */
public class 打家劫舍III {
    Map<TreeNode, Integer> f = new HashMap<>();// 表示选择root结点能偷到的最大值
    Map<TreeNode, Integer> g = new HashMap<>();// 表示不选择root结点能偷到的最大值

    public int rob(TreeNode root) {
        recur(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    /**
     * O(T)=O(n);对二叉树进行了后序遍历，时间复杂度是O(n);
     * O(S)=O(n);空间复杂度来自递归栈的调用，最坏情况下树的深度==树的节点数，存储f和g的结果也需要O(n)的空间！
     *
     * @param root
     */
    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        recur(root.left);
        recur(root.right);
        // 选中root结点能偷到的最大值是root.val+ 不选中root.left能偷到的最大值+不选中root.right能偷到的最大值
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        // 不选中root结点能偷到的最大值是选中root.left能偷到的最大值和不选中root.left能偷到的最大值的较大者 +
        // 选中root.right能偷到的最大值和不选中root.right能偷到的最大值的较大者
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) +
                Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
