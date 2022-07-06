package leecode.recur;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/17:07
 * @Description:
 */
public class 对称二叉树方法2 {
    /**
     * 把递归的过程用队列摸出来，就变成了迭代程序；
     * 1.先往队列里加入两个结点，然后依次取出两个连续的结点，则作为对称二叉树这两个连续的结点必须相等；
     * 在控制这两个结点子节点加入的顺序是相反的，也就是实现了递归中l指针往左走，r指针往右走，l指针往右走，r指针往左走！
     *O(T)=O(n)；
     *O(S)=O(n);
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return valid(root, root);
    }

    public boolean valid(TreeNode l, TreeNode r) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(l);
        queue.offer(r);
        while (!queue.isEmpty()) {
            l = queue.poll();
            r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            queue.offer(l.left);
            queue.offer(r.right);

            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }
}
