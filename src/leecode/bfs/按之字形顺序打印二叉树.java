package leecode.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/10:50
 * @Description:
 */
public class 按之字形顺序打印二叉树 {
    /**
     * 跟层序遍历类似，但打印完一行之后，需要设置一个变量，再反向打印；
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int level = 0;// 标记打印顺序，为偶数从左到右打印，奇数从右到左打印
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            if (level % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    // 从左往右打印，则从头部出队，
                    TreeNode cur = queue.removeFirst();
                    if (cur.left != null) {
                        // 为了不影响头部元素，就从尾部入队；
                        queue.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offerLast(cur.right);
                    }
                    list.add(cur.val);
                }
                ans.add(list);
            } else {
                list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    // 从右往左打印，则从尾部出队
                    TreeNode cur = queue.removeLast();
                    // 先加右子树，再加左子树
                    if (cur.right != null) {
                        // 为了不影响尾部元素出队，要从头部入队！
                        queue.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offerFirst(cur.left);
                    }
                    list.add(cur.val);
                }
                ans.add(list);
            }
            level++;
        }
        return ans;
    }
}
