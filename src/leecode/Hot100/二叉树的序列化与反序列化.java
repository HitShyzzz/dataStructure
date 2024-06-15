package leecode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 16:41
 */
public class 二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs1(root, "");
    }

    public String dfs1(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
        } else {
            s += root.val + ",";
            s = dfs1(root.left, s);
            s = dfs1(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> dataArray = new ArrayList<>(Arrays.asList(split));
        TreeNode root = dfs2(dataArray);
        return root;
    }

    public TreeNode dfs2(List<String> dataArray) {
        if (dataArray.get(0).equals("null")) {
            dataArray.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArray.get(0)));
        dataArray.remove(0);
        root.left = dfs2(dataArray);
        root.right = dfs2(dataArray);
        return root;
    }
}
