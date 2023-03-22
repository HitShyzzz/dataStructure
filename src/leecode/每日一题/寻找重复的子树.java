package leecode.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/05/8:51
 * @Description:
 */
public class 寻找重复的子树 {
    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serial(root);
        return new ArrayList<>(repeat);
    }

    /**
     * @param root 二叉树的根结点
     * @return 二叉树序列化的结果
     */
    public String serial(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(serial(root.left));
        sb.append(")(");
        sb.append(serial(root.right));
        sb.append(")");
        String res = sb.toString();
        if (map.containsKey(res)) {
            repeat.add(map.get(res));
        } else {
            map.put(res, root);
        }
        return res;
    }

//    /**
//     * 用bfs实现二叉树的序列化
//     *
//     * @param root
//     * @return
//     */
//    public String serial(TreeNode root) {
//        if (root == null) {
//            return "[]";
//        }
//        StringBuilder sb = new StringBuilder();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        sb.append(root.val);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            if (cur != null) {
//                sb.append(cur.val + ",");
//                queue.offer(cur.left);
//                queue.offer((cur.right));
//            } else {
//                sb.append(null + ",");
//            }
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append("]");
//        return sb.toString();
//    }
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
