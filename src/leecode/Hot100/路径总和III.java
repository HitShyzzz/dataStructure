package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-03 22:29
 */
public class 路径总和III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int i = pathSum(root, 8);
        System.out.println(i);

    }

    /**
     * @description:
     * @return: 以root为根结点向下和为targetSum的路径和=以root为起点向下和为targetSum的路径和+以root.left
     * 为起点向下和为targetSum的路径和+以root.right为起点向下和为targetSum的路径和
     **/
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 以root为起点和为targetSum的数量
        int res = dfs(root, targetSum);
        // 以root.left为起点和为targetSum的数量
        res += pathSum(root.left, targetSum);
        // 以root.right为起点和为targetSum的数量
        res += pathSum(root.right, targetSum);
        return res;
    }

    // 表示以root为起点向下路径和为targetSum的数量
    public static int dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }
}
