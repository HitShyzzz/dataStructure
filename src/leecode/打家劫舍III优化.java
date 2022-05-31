package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/20/13:04
 * @Description:
 */
public class 打家劫舍III优化 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int selected = root.val + l[1] + r[1];//l(1),r(1)表示不选择当前的左子节点和右子节点
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
