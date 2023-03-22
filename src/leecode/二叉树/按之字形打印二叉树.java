package leecode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/22/10:13
 * @Description:
 */
public class 按之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);
        boolean flag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            flag = !flag;
            if (flag) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pollFirst();
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                    list.add(cur.val);
                }
                ans.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pollLast();
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                    list.add(cur.val);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
