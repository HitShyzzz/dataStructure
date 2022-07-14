package leecode.数学;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/20:38
 * @Description:
 */
public class 移动零 {
    /**
     * 用list存放所有不为0的元素，再把nums数组全部赋值为0，再把list的不为零的元素赋值给nums数组的前面！
     * O(T)=O(n);
     * O(S)=O(k);k是nums数组中非零元素的个数，
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int k=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                k++;
                list.add(nums[i]);
            }
        }
        Arrays.fill(nums,0);
        for(int i=0;i<k;i++){
            nums[i]=list.get(i);
        }
    }
}
