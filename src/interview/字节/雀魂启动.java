package interview.字节;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/16/10:40
 * @Description:
 */
public class 雀魂启动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[9];
        for (int i = 0; i < 13; i++) {
            nums[Integer.valueOf(s1[i]) - 1]++;
        }
        List<Integer> list = huPai(nums);
        for (Integer key : list) {
            System.out.print(key + " ");
        }
    }

    public static void arrayCopy(int[] original, int[] copy) {
        for (int i = 0; i < copy.length; i++) {
            copy[i] = original[i];
        }
    }

    public static List<Integer> huPai(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] copy = new int[nums.length];
        for (int i = 0; i < 9; i++) {
            arrayCopy(nums, copy);
            if (nums[i] < 4) {
                nums[i]++;
                if (win(false, 14, nums)) {
                    list.add(i + 1);
                }
                nums[i]--;
            }
            arrayCopy(copy, nums);
        }
        if (list == null || list.size() == 0) {
            list.add(0);
        }
        return list;
    }

    public static boolean win(boolean hasHead, int count, int[] nums) {
        if (count == 0) {
            return true;
        }
        // 选出雀头
        if (hasHead) {
            for (int i = 0; i < 9; i++) {
                // 3张相同的
                if (nums[i] > 2) {
                    nums[i] -= 3;
                    if (win(true, count - 3, nums)) {
                        return true;
                    }
                    nums[i] += 3;
                }
                // 3张连续的
                if (i < 7 && nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0) {
                    nums[i] -= 1;
                    nums[i + 1] -= 1;
                    nums[i + 2] -= 1;
                    if (win(true, count - 3, nums)) {
                        return true;
                    }
                    nums[i] += 1;
                    nums[i + 1] += 1;
                    nums[i + 2] += 1;
                }
            }
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (nums[i] > 1) {
                    nums[i] -= 2;
                    if (win(true, count - 2, nums)) {
                        return true;
                    }
                    nums[i] += 2;
                }
            }
            return false;
        }
    }
}
