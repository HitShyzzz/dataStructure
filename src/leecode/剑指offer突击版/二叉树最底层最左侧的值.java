package leecode.剑指offer突击版;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/15:16
 * @Description:
 */
public class 二叉树最底层最左侧的值 {
    int curVal = 0;// 当前高度最左侧的值
    int curHeight = 0;// 当前高度

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    /**
     *
     * @param root 根节点
     * @param Height 当前结点高度
     */
    public void dfs(TreeNode root, int Height) {
        if (root == null) {
            return;
        }
        Height++;
        dfs(root.left, Height);
        dfs(root.right, Height);
        if (Height > curHeight) {
            curHeight = Height;
            // 先遍历左子树，再遍历右子树，因此左子结点一定是先遍历到的！
            curVal = root.val;
        }
    }
}
