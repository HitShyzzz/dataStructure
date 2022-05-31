package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/30/14:16
 * @Description:
 */
public class 从根到叶的二进制数之和 {
    public static void main(String[] args) {
        int a = 3 | 2;
        System.out.println(a);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1 | root.val);
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
