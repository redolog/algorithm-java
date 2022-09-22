package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 *
 * @author songhuilong  @date 2022/9/22
 */
public class CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        if (arr.length == 1) {
            return arr[0] == pieces[0][0];
        }
        Map<Integer, Integer> num2Idx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            num2Idx.put(arr[i], i);
        }

        // pieces内每一个子数组内，需保证arr一致的元素相对顺序
        for (int[] pieceArr : pieces) {
            for (int i = 0; i + 1 < pieceArr.length; i++) {
                if (!num2Idx.containsKey(pieceArr[i]) || !num2Idx.containsKey(pieceArr[i + 1])) {
                    return false;
                }

                // i 表示当前，i+1表示next
                if (num2Idx.get(pieceArr[i]) - num2Idx.get(pieceArr[i + 1]) != -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
