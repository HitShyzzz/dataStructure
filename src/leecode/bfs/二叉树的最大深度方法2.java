package leecode.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/18:42
 * @Description:
 */
public class 二叉树的最大深度方法2 {
    /**
     * Bfs，对二叉树每一层的每个结点都要向下进行扩展，扩展一次深度就要加1；
     * O(T)=O(n);每个结点只会进出一次队列，每个结点都需要扩展到！
     * O(S)=O(n),最坏情况下是O(n);
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();// 当前层的结点数量
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
