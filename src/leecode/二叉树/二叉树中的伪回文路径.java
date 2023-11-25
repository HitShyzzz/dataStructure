package leecode.二叉树;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-25 18:32
 */
public class 二叉树中的伪回文路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        int i = pseudoPalindromicPaths(root);
        System.out.println(i);
    }

    // 输入：root = [2,3,1,3,1,null,1]
    // 输出：2
    // 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
    // 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
    public static int pseudoPalindromicPaths(TreeNode root) {
        int[] cnt = new int[10];
        int res = dfs(root, cnt);
        return res;
    }

    /**
     * @description:
     * @author: shy
     * @date: 2023/11/25 19:38
     * @param:
     * @param: root
     * @param: cnt
     * @return: int 以当前结点为父结点的叶子结点到root结点路径能构成伪回文序列的个数
     **/
    public static int dfs(TreeNode root, int[] cnt) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        cnt[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(cnt)) {
                res = 1;
            }
        } else {
            res = dfs(root.left, cnt) + dfs(root.right, cnt);
        }
        cnt[root.val]--;
        return res;
    }

    // 判断一个排列是否是伪回文序列

    /**
     * @description: 一个排列能形成回文序列，当排列长度为偶数时，每个元素出现的次数一定要是偶数
     * 当排列长度是奇数时，除了中间位置那个元素出现次数可以是奇数以外，其他位置元素出现次数一定要是偶数
     * 也就是至多有一个元素出现的次数是奇数！
     * @author: shy
     * @date: 2023/11/25 19:33
     * @param:
     * @param: cnt 记录每个元素出现的次数
     * @return: boolean
     **/
    public static boolean isPseudoPalindromic(int[] cnt) {
        int count = 0;
        for (int value : cnt) {
            if (value % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
