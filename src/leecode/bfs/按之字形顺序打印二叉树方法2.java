package leecode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/11:38
 * @Description:
 */
public class 按之字形顺序打印二叉树方法2 {
    /**
     * 还是BFS，不同的是我们打印一次，就变一下标记，然后把集合反转一下就好了！
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean flag = false;
        if (pRoot == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            flag = !flag;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            if (!flag) {
                Collections.reverse(list);
            }
            ans.add(list);
        }
        return ans;
    }
}
