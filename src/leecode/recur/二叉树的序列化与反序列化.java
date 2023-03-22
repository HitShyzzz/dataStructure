package leecode.recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/21:52
 * @Description:
 */
public class 二叉树的序列化与反序列化 {

}

/**
 * O(T)=O(n);在序列化和反序列化中，我们只会访问每个结点1次，故时间复杂度是O(n);
 * O(S)=O(n);空间复杂度主要来自递归空间栈的调用！
 */
class Codec {
    /**
     * 序列化，我们采用dfs的方式，对二叉树进行先序遍历，如果当前结点为空，就在结果字符串中加上None,
     * 然后递归的遍历左子树和右子树就行了！
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recur(root, "");

    }

    public String recur(TreeNode root, String s) {
        if (root == null) {
            return s += "None,";
        }
        s += root.val + ",";
        s = recur(root.left, s);
        s = recur(root.right, s);
        return s;
    }

    /**
     * 反序列化的时候，先根据“，”得到原始的数组字符串，然后再进行先序遍历，还原二叉树！
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] StringData = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(StringData));
        return recur(list);
    }

    public TreeNode recur(List<String> list) {
        if (list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = recur(list);
        root.right = recur(list);
        return root;
    }
}
