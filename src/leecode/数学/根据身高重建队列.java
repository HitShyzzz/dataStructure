package leecode.数学;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/17:55
 * @Description:
 */
public class 根据身高重建队列 {
    /**
     * 核心思路：第i个人的位置就在重排后的ki+1个位置，
     * O(T)=O(n^2),排序需要O(nlogn),把每个person放到结果集的ki+1位置需要O(n^2)，因此总的时间复杂度就是O(n^2);
     * O(S)=O(logn);排序需要的栈空间！
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 先按身高升序排列，再按k值降序排列，这样当身高相同时，k值更大的虽然在people数组中排到了更前面的位置，
        // 那么它的space=ki+1就会更大，在最终排好的结果集中位置就会更加的靠后！
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < n; i++) {
                // 这里space减少到0，那么i就会增加space次，刚好到结果集的ki+1的位置!
                if (ans[i] == null) {
                    space--;
                    if (space == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
