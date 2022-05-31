package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/11:14
 * @Description:
 */
public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=1;i<=n;i++){
            map.put(i,0);
        }
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])+1);
        }
        List<Integer>list=new ArrayList<>();
        for(int i: map.keySet()){
            if(map.get(i)==0){
                list.add(i);
            }
        }
        return list;
    }
}
