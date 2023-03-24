package leecode.½£Ö¸offerÍ»»÷°æ;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/24/9:16
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(TreeNode left,TreeNode right,int val){
        this.left=left;
        this.right=right;
        this.val=val;
    }
}
