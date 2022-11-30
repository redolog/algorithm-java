package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/relative-sort-array/
 *
 * @author songhuilong  @date 2022/11/30
 */
public class RelativeSortArray {

    /**
     * 对arr1中的元素计数
     * 每遍历一个arr2中的元素，就按照频率拼接对应值
     * 最后将arr1中还存在计数，即不存在arr2中的，顺次拼到ans最后
     * <p>
     * 设 len(arr1)==m len(arr2)==n
     * 时间：O(m+n+1001)
     * 空间：O(1001+m)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int num : arr1) {
            cnt[num]++;
        }
        // j表示写入到arr1的下标
        int j = 0;
        for (int num : arr2) {
            while (cnt[num]-- > 0) {
                arr1[j++] = num;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (cnt[i]-- > 0) {
                arr1[j++] = i;
            }
        }
        return arr1;
    }
}
