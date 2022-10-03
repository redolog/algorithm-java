package com.algorithm.probability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/random-pick-index/
 *
 * @author DragonSong  @date 2022/10/3
 */
public class RandomPickIndex {

    Map<Integer, List<Integer>> num2Indexes;

    public RandomPickIndex(int[] nums) {
        num2Indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = num2Indexes.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            num2Indexes.put(nums[i], list);
        }
    }

    public int pick(int target) {
        if (!num2Indexes.containsKey(target)) {
            return -1;
        }
        List<Integer> indexes = num2Indexes.get(target);
        if (indexes == null || indexes.size() == 0) {
            return -1;
        }
        // random() 返回 [0,1)
        // *size() 返回 [0,size)
        int randomIdx = (int) (Math.random() * indexes.size());
        return indexes.get(randomIdx);
    }
}
