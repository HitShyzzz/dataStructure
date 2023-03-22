package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/03/13:42
 * @Description:
 */
public class 把二叉搜索树转化为累加树方法2 {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            // 右子树为空
            if (node.right == null) {
                // 处理当前节点
                sum += node.val;
                node.val = sum;
                // 遍历当前节点的左子节点
                node = node.left;
            } else {// 右子节点不为空
                // 找到当前节点中序遍历的前驱节点
                TreeNode succ = getSuccessor(node);
                // succ左指针为空
                if (succ.left == null) {
                    // succ的左指针指向当前节点
                    succ.left = node;
                    // 遍历当前节点的右子节点
                    node = node.right;
                } else {// succ左指针不为空
                    // succ左指针置空
                    succ.left = null;
                    // 处理当前节点
                    sum += node.val;
                    node.val = sum;
                    // 当前节点置为其左子节点
                    node = node.left;
                }
            }
        }
        return root;
    }

    // 获得当前节点中序遍历的前驱节点
    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        // 前驱节点一定在当前右子树的最左边，或者前驱节点的左指针已经指向当前节点
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
