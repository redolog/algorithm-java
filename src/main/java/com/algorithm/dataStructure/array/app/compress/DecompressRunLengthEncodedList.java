package com.algorithm.dataStructure.array.app.compress;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/decompress-run-length-encoded-list/
 *
 * @author DragonSong  @date 2022/10/3
 */
public class DecompressRunLengthEncodedList {
    /**
     * 使用list来装数据，n表示list.size()
     * 时间复杂度：O(n)
     * 空间复杂度：额外的list为空间开销，O(n)
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int j = 0;
            while (j < nums[i]) {
                list.add(nums[i + 1]);
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 多遍历一次nums算出结果集的size n，可以不用额外的空间开销
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int[] decompressRLElist2(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i += 2) {
            n += nums[i];
        }
        int[] ans = new int[n];
        int insertIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans[insertIdx++] = nums[i + 1];
            }
        }
        return ans;
    }
}
