package leecode.每日一题;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 9:07
 */
public class 分糖果 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = Arrays.stream(candyType).boxed().collect(Collectors.toCollection(HashSet::new));
        return Math.min(candyType.length / 2, set.size());
    }
}
