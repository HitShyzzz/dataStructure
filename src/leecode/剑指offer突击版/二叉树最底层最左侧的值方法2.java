package leecode.剑指offer突击版;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/15:16
 * @Description:
 */
public class 二叉树最底层最左侧的值方法2 {

    // BFS,每次从右边加入，那么队列最后的最后一个结点值就是最左侧的结点
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            ans=node.val;
        }
        return ans;
    }
}
