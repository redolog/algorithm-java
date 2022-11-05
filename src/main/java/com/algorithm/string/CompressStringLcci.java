package com.algorithm.string;

/**
 * https://leetcode.cn/problems/compress-string-lcci/
 *
 * @author DragonSong  @date 2022/11/5
 */
public class CompressStringLcci {

    /**
     * 时间：完整遍历一次s，O(n)
     * 空间：除ans外无其他空间开销，O(1)
     */
    public String compressString(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char segStart = s.charAt(i);
            ans.append(segStart);
            int segCnt = 1;
            while (i + 1 < n && s.charAt(i + 1) == segStart) {
                segCnt++;
                i++;
            }
            ans.append(segCnt);
            if (ans.length() >= n) {
                return s;
            }
        }
        return ans.toString();
    }
}
