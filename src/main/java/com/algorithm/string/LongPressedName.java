package com.algorithm.string;

/**
 * https://leetcode.cn/problems/long-pressed-name/
 *
 * @author songhuilong001  @date 2022/11/24
 */
public class LongPressedName {

    /**
     * 双指针，同时遍历 name、typed
     * <p>
     * 时间：O(max(name.len, typed.len))
     * 空间：O(1)
     */
    public boolean isLongPressedName(String name, String typed) {
        int nLen = name.length(), tLen = typed.length();
        if (tLen < nLen) {
            return false;
        }
        int nI = 0, tI = 0;
        for (; nI < nLen && tI < tLen; nI++, tI++) {
            char nCurr = name.charAt(nI), tCurr = typed.charAt(tI);
            if (nCurr != tCurr) {
                return false;
            }
            // 统计当前字符在当前段的出现次数
            int nCnt = 1, tCnt = 1;
            while (nI + 1 < nLen && name.charAt(nI + 1) == nCurr) {
                nI++;
                nCnt++;
            }
            while (tI + 1 < tLen && typed.charAt(tI + 1) == nCurr) {
                tI++;
                tCnt++;
            }
            if (nCnt > tCnt) {
                return false;
            }
        }
        while (tI < tLen) {
            if (typed.charAt(tI) != name.charAt(nLen - 1)) {
                return false;
            }
            tI++;
        }
        return nI == nLen;
    }
}
