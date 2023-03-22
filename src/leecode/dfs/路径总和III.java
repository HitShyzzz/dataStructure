package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/23:33
 * @Description:
 */
public class 路径总和III {

    /**
     * O(T)=O(n^2);每个结点都需要遍历是O(n),我们去找以root结点为根节点的数目的时候，又要分别以root的子树为根结点去找新的
     * 子树的数目，需要O(n)的时间，总的时间复杂度就是O(n^2);
     * O(S)=O(n)；空间复杂度主要来自递归空间栈的调用！
     *
     * @param root
     * @param targetSum
     * @return 以root为根节点的树和为targetSum的个数，但真正计算的时候不一定非要以root结点为起点呀，
     * pathNum=pathSum(root,targetNum)+pathNum(root.left,targetNum)+pathNum(root.right,targetNum);
     * 也就是最后的结果应该是以root结点为根的树的数目+以root.left结点为根的树的数目+以root.right结点为根的树的数目；
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int pathNum = dfs(root, targetSum);
        pathNum += pathSum(root.left, targetSum);
        pathNum += pathSum(root.right, targetSum);
        return pathNum;
    }

    /**
     * 那么dfs(root,targetSum)=dfs(root,targetSum-root.val)+dfs(root,targetSum-root.val);
     *
     * @param root
     * @param targetSum
     * @return 以root结点为起点向下查找和为targetSum的数目；
     */
    public int dfs(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        // 如果当前结点的值刚好就等于targetSum,那么res也要加1；
        if (val == targetSum) {
            res++;
        }
        res += dfs(root.left, targetSum - val);
        res += dfs(root.right, targetSum - val);
        return res;
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
