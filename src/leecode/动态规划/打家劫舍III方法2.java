package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/22:01
 * @Description:
 */
public class 打家劫舍III方法2 {

    public int rob(TreeNode root) {
        int[] res = recur(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 用数组去存储不选择root结点和选择root结点的结果
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param root
     * @return
     */
    public int[] recur(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // left[0]表示选择当前结点，left[1]表示不选择当前结点
        int[] left = recur(root.left);
        // right[0]表示选择当前结点，right[1]表示不选择当前结点
        int[] right = recur(root.right);
        int selected = root.val + left[1] + right[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, notSelected};
    }
}
