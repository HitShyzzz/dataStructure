package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-26 20:58
 */
public class 二叉树的层序遍历 {
    // 输入：root = [3,9,20,null,null,15,7]
    // 输出：[[3],[9,20],[15,7]]
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            // 把同一层的结点都放到同一个list里面
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
                list.add(cur.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
