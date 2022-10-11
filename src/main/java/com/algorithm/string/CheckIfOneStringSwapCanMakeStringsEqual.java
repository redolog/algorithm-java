package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * @author songhuilong  @date 2022/10/11
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        // 记录不一样的下标位置，同时不同位置数量只能为0,2
        if (s1.equals(s2)) {
            return true;
        }
        List<Integer> diffIdxList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIdxList.add(i);
            }
            if (diffIdxList.size() > 2) {
                return false;
            }
        }
        if (diffIdxList.size() != 0 && diffIdxList.size() != 2) {
            return false;
        }
        if (diffIdxList.size() == 0) {
            return true;
        }
        int idx1 = diffIdxList.get(0), idx2 = diffIdxList.get(1);
        return s1.charAt(idx1) == s2.charAt(idx2) && s2.charAt(idx1) == s1.charAt(idx2);
    }
}
