package leecode.数学;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/21:08
 * @Description:
 */
public class 寻找重复数 {

    /**
     * 先排序，那么重复的元素必然挨在一起，
     * O(T)=O(nlogn);
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}
