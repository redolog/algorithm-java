package com.algorithm.string;

/**
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * @author DragonSong  @date 2022/10/16
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    /**
     * 时间复杂度：完整遍历一次s，O(n)
     * 空间复杂度：使用了额外的一个n大小的数组计数，O(n)
     */
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        // 对我们的序列记录计数
        int[] i2Cnt = new int[n];
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length(); i++) {
            char currC = builder.charAt(i);
            // 第一个字符、前序与当前字符不等时计数为1
            if (i == 0 || builder.charAt(i - 1) != currC) {
                i2Cnt[i] = 1;
            } else if (builder.charAt(i - 1) == currC) {
                // 计数累加
                i2Cnt[i] = i2Cnt[i - 1] + 1;
            }
            if (i2Cnt[i] == k) {
                // 达到k个一批相等字符序列，删除一批k个元素
                for (int j = 0; j < k; j++) {
                    builder.deleteCharAt(i - j);
                }
                // 指针回退k个位
                i = i - k;
            }
        }
        return builder.toString();
    }
}
