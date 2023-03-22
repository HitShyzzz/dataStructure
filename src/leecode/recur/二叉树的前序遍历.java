package leecode.recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/05/11:55
 * @Description:
 */
public class 二叉树的前序遍历 {
    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal(TreeNode root) {
        // write code here
        // list<Integer>转化int[]数组的方法
        preOrder(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
