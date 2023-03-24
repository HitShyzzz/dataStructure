package leecode.剑指offer突击版;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/9:15
 * @Description:
 */
public class 二叉树中和为某一值的路径 {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer>list=new ArrayList<>();
        dfs(root,0,target,list);
        return ans;
    }

    public void dfs(TreeNode root, int sum, int target, List<Integer>list){
        if(root==null){
            return;
        }
        // 添加当前结点
        list.add(root.val);
        sum+=root.val;
        // 遍历到了叶子结点，就返回结果
        if(root.left==null&&root.right==null&&sum==target){
            ans.add(new ArrayList<>(list));
        }
        dfs(root.left,sum,target,list);
        dfs(root.right,sum,target,list);
        list.remove(list.size()-1);
    }
}
