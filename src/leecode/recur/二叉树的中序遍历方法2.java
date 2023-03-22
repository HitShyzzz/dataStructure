package leecode.recur;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/06/16:29
 * @Description:
 */
public class 二叉树的中序遍历方法2 {
    /**
     * 用栈去实现二叉树的中序遍历，
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return  list;
        }
        Deque<TreeNode>stack=new LinkedList<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }
}
