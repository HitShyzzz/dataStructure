package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/05/11:55
 * @Description:
 */
public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        int n=19;
        int trees = numTrees(n);
        System.out.println(trees);
    }
    /**
     * 二叉搜索树必须满足left.val<root.val<right.val,那么对于以i为root结点的二叉搜索树，总共的不同的二叉搜索树个数
     * 是左子树二叉搜索树的个数*右子树二叉搜索树的个数。而左子树有i-1种取法，右子树有n-i种取法，递归一一遍历每个root结点
     * 就好了
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if(n==1||n==0){
            return 1;
        }
        int count=0;
        for(int i=1;i<=n;i++){
            int leftOfCount=numTrees(i-1);
            int rightOfCount=numTrees(n-i);
            count+=leftOfCount*rightOfCount;
        }
       return count;
    }
}
