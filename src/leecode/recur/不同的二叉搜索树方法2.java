package leecode.recur;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/05/12:15
 * @Description:
 */
public class 不同的二叉搜索树方法2 {
    public static void main(String[] args) {
        int n=19;
        int trees = numTrees(n);
        System.out.println(trees);
    }

    private static Map<Integer,Integer> map=new HashMap<>();

    /**
     * 方法1是最基本的递归，但中间存在大量的重复计算，因此我们可以利用hashMap来存储中间结果，以优化时间复杂度！
     * O(T)=O(n),每个点都需要做一次root结点，
     * O(S)=O(n),需要hashMap来存储中间结果！
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if(n==1||n==0){
            return 1;
        }
        Integer key=n;
        if(map.get(key)!=null){
            return map.get(key);
        }
        int count=0;
        for(int i=1;i<=n;i++){
            int leftOfCount=numTrees(i-1);
            int rightOfCount=numTrees(n-i);
            count+=leftOfCount*rightOfCount;
        }
        map.put(key,count);
        return count;
    }
}
