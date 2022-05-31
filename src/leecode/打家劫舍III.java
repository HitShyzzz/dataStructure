package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/20/11:44
 * @Description:
 */
public class 打家劫舍III {
    Map<TreeNode, Integer> f = new HashMap<>();// f表示选中节点o能偷盗的最大值；
    Map<TreeNode, Integer> g = new HashMap<>();// g表示不选中节点o能偷盗的最大值；

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        // 这句话是说选中f(o)=o.val+g(l)+g(r);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        // 不选中节点o,g(o)=Math.max(f(l),g(l))+Math.max(f(r),g(r));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
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
