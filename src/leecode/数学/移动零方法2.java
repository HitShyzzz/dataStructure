package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/20:45
 * @Description:
 */
public class 移动零方法2 {
    /**
     * 直接原地覆盖，再把后面补0；
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        for(int i=index;i<n;i++){
            nums[i]=0;
        }
    }
}
