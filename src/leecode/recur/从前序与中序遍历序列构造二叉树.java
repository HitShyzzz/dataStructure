package leecode.recur;


import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/20:45
 * @Description:
 */
public class 从前序与中序遍历序列构造二叉树 {
    // 这里把index放到这里，是因为当前层递归的左子树和右子树都是以preOrder[index]为root结点的！
    int index = 0;
    // 用来存储中序遍历元素的下标对应关系，便于找到左子树和右子树！
    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, preorder.length - 1, preorder);
    }

    /**
     * 不断的从前序序列中拿出root结点，然后在中序序列中root结点以左的就是左子树，root结点以右的就是右子树！
     * 我们需要利用hashMap找到前序遍历的结点在中序序列中的位置!
     * O(T)=O(n);需要遍历一遍前序遍历，存储中序遍历结点和下标的对应关系的时间复杂度也是O(n);
     * O(S)=O(n);需要O(n)的空间来存储存储中序遍历结点和下标的对应关系！
     *
     * @param l        左边界
     * @param r        右编辑
     * @param preorder 前序遍历序列
     * @return 以l为左边界和以r为右边界构造二叉树的根结点
     */
    public TreeNode recur(int l, int r, int[] preorder) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = recur(l, map.get(preorder[index]) - 1, preorder);
        root.right = recur(map.get(preorder[index]) + 1, r, preorder);
        return root;
    }
}
