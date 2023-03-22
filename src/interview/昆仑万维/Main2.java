package interview.昆仑万维;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/05/19:28
 * @Description:
 */
public class Main2 {
    public int sum_numbers(TreeNode root) {
        // write code here
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int temp = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return dfs(root.left, temp) + dfs(root.right, temp);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
