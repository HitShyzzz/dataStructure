package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/02/10:18
 * @Description:
 */
public class 目标和 {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return count;
    }

    public void dfs(int[]nums,int target,int index,int sum){
        if(index==nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        dfs(nums,target,index+1,sum+nums[index]);
        dfs(nums,target,index+1,sum-nums[index]);
    }
}
