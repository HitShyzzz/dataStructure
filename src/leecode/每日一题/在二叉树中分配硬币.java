package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/07/14/10:32
 * @Description:
 */
public class 在二叉树中分配硬币 {
    int ops = 0;// 记录总的操作数

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ops;
    }

    /**
     * 递归写法，理解递归函数的含义是关键！
     * <p>
     * dfs(root)<0则表示root结点需要从root的根结点拿取|dfs(root)|个金币，因此不管怎么移动，父子结点之间拿取的
     * 金币数一定是|dfs(root)|
     *
     * @param root
     * @return 以root为根节点的子树调整成每个子结点都是1个金币，root的父结点需要从root结点拿走的金币数量
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int moveLeft = 0;
        int moveRight = 0;
        if (root.left != null) {
            moveLeft = dfs(root.left);
        }
        if (root.right != null) {
            moveRight = dfs(root.right);
        }
        ops += Math.abs(moveLeft) + Math.abs(moveRight);
        // 本身还要留一枚金币，因此dfs(root)=moveRight+moveLeft+root.val-1
        return moveLeft + moveRight + root.val - 1;
    }

}
