package interview.美团;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/03/10:45
 * @Description:
 */
public class Main2 {
   private static Set<Character>set=new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String dic = in.nextLine();
        String[] str = s.split(" ");
        TreeNode root=new TreeNode(0);
        for (int i = 1; i <= n; i++) {
                TreeNode curNode = new TreeNode(i);
                curNode.val = dic.charAt(i - 1);
                for(int j=0;j< str.length;j++){
                    int cur=Integer.parseInt(str[j]);
                    if (cur+1==i){
                        if (curNode.left==null){
                            curNode.left=new TreeNode(j+2);
                        }else{
                            curNode.right=new TreeNode(j+2);
                        }
                    }
                }
            }

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            TreeNode cur=new TreeNode(i+1);
            dfs(cur);
            ans[i]=set.size();
            set.clear();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void dfs( TreeNode root) {
        if (root == null) {
            return ;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class TreeNode {
    int i;// 结点编号
    TreeNode left;
    TreeNode right;
    char val;

    public TreeNode(int i) {
        this.i = i;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
