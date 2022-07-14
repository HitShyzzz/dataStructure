package leecode.recur;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/13/8:56
 * @Description:
 */
public class 二叉树的最近公共祖先方法2 {
    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();

    /**
     * 非递归实现，首先利用hashMap去记录每个结点的父节点信息，然后从p向上找他的父节点，并记录已经访问过的结点，
     * 再从q向上找父节点，当q首次访问到p已经访问过的节点时，这个结点就是p和q的最近公共祖先！
     * O(T)=O(n),n是二叉树结点的数目，向上找父节点时，访问的节点数不会超过n;
     * O(S)=O(n),存储每个结点的信息需要O(n)的额外空间，递归最坏情况下也需要O(n)的空间！
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root);
        while (p != null) {
            set.add(p);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * 往hashMap里存储每个结点的父亲结点
     *
     * @param root
     */
    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            recur(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            recur(root.right);
        }
    }
}

