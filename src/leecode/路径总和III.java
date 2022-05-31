package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/27/9:20
 * @Description:
 */
public class 路径总和III {
    int path = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            path++;
        }
        dfs(root.left, targetSum - root.val, 0);
        dfs(root.right, targetSum - root.val, 0);
        dfs(root.left, targetSum, 1);
        dfs(root.right, targetSum, 1);
        return path;
    }
    public void dfs(TreeNode root, int targetSum, int flag) {
        if (root == null) {// 如果都没有符合的，就从这出去了，path让然为0；这是遍历完所有节点之后就从这出去了；
            return;
        }
        if (root.val == targetSum) {// 这里不要让它出去，让它把所有的找完再出去！
            path++;
        }
        // 表示不添加root节点，也就是root节点为起始节点向下搜索
        if (flag == 1) {
            dfs(root.left, targetSum, 1);
            dfs(root.right, targetSum, 1);
        } // flag==0,对应添加root节点，也就是要以root节点为起始节点
        dfs(root.left, targetSum - root.val, 0);// 只要递归还在往下走，说明就没找到，
        dfs(root.right, targetSum - root.val, 0);
    }
}
