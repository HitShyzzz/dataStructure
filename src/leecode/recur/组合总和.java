package leecode.recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/23/10:29
 * @Description:
 */
public class 组合总和 {
    public static void main(String[] args) {
        int[]candidates={2,3,6,7};
        int target=7;
        long start=  System.currentTimeMillis();
        List<List<Integer>> lists = combinationSum(candidates, target);
        long end=System.currentTimeMillis();
        System.out.println("算法花的时间为："+(end-start)+"ms");
        for(List<Integer>list:lists){
            System.out.println(list);
        }
    }
    private static List<List<Integer>>ans=new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       // recur(candidates,target,0,new ArrayList<>());
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(),candidates,target,0,0);
        return ans;
    }

    /**
     * 这里应该可以先排序再递归来剪枝优化时间复杂度，但我没看明白！
     * @param candidates
     * @param target
     * @param index
     * @param list
     */
    public static void recur(int[]candidates,int target,int index,List<Integer> list){
        if(index==candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target>0){
                // 这里的处理太好了！它会先一直去添加candidates[i]，直到target<0,也就是加超了
                // 一旦加超了立马开始回溯，把最后加的去掉，同时跳出这个if
                list.add(candidates[i]);
                recur(candidates,target-candidates[i],i,list);
                list.remove(list.size()-1);
            }else{
                break;
            }
        }
    }

    private static void backtrack(List<Integer> path,int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            /**
             * 这里优化的道理是先用变量rs记录加上candidates[i]后的结果，一旦超了就根本不进去，少一层递归，
             * 当然会快很多，这样做的话就需要排序！
             */
            int rs = candidates[i] + sum;
            if(rs <= target) {
                path.add(candidates[i]);
                backtrack(path,candidates,target,rs,i);
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }
}
