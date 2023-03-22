package leecode.模拟;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/15:41
 * @Description:
 */
public class 只出现一次的数字 {

    /**
     * 利用hashMap去统计每个字符出现的次数，然后返回次数为1的；
     * O(T)=O(n);
     * O(S)=O(n);使用了额外的空间；
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)==1){
                ans=num;
                break;
            }
        }
        return ans;

    }
}
