package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-26 20:28
 */
public class 从前序和中序遍历序列构造二叉树 {

    // 存放中序遍历元素和下标的对应关系
    public Map<Integer, Integer> map = new HashMap<>();
    int index = 0;

    // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // 输出: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length, preorder);
    }

    public TreeNode dfs(int l, int r, int[] preorder) {
        if (l > r || index == preorder.length)
            return null;
        int val = preorder[index];
        index++;
        TreeNode root = new TreeNode(val);
        // root的左子树就是当前结点root在中序遍历序列相应位置左侧的元素
        root.left = dfs(l, map.get(val) - 1, preorder);
        // root的右子树就是当前结点root在中序遍历序列相应位置右侧的元素
        root.right = dfs(map.get(val) + 1, r, preorder);
        return root;
    }

}
