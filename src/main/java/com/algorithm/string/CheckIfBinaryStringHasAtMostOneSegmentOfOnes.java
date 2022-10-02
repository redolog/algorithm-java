package com.algorithm.string;

/**
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * @author DragonSong  @date 2022/10/3
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    /**
     * 对符合条件的段计数
     * <p>
     * n表示s长度
     * 时间复杂度：完整遍历一次s，O(n)
     * 空间复杂度：无额外空间开销，O(1)
     */
    public boolean checkOnesSegment(String s) {
        int oneCnt = 0;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (pre == '1' && curr == '0') {
                oneCnt++;
            }
            pre = curr;
        }
        // 尾缀为1，for中判断覆盖不到，最后特判一次
        if (pre == '1') {
            oneCnt++;
        }
        return oneCnt <= 1;
    }

    public boolean checkOnesSegment2(String s) {
        return !s.contains("01");
    }
}
