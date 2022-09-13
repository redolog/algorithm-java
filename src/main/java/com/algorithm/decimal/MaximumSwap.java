package com.algorithm.decimal;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-swap/
 *
 * @author songhuilong  @date 2022/9/13
 */
public class MaximumSwap {

    /**
     * 替换：最靠近高位的较小元素、最靠近低位的最大元素
     */
    public int maximumSwap(int num) {
        int numTmp = num;
        List<Integer> list = new ArrayList<>();
        int max = -1;
        int maxIdx = -1, lessIdx = -1, gtIdx = -1;
        while (numTmp > 0) {
            int curr = numTmp % 10;
            int prevIdx = list.size() - 1;
            if (max < curr) {
                // 出现倒序下降/持平趋势，记录位置
                max = curr;
                maxIdx = prevIdx + 1;
            }
            if (max > curr) {
                lessIdx = prevIdx + 1;
                gtIdx = maxIdx;
            }

            list.add(curr);
            numTmp /= 10;
        }

        if (gtIdx == -1) {
            return num;
        }

        // 交换出现了下降趋势的最大值与最靠近高位的较小值
        Integer min = list.get(lessIdx);
        list.set(lessIdx, list.get(gtIdx));
        list.set(gtIdx, min);

        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans = ans * 10 + list.get(i);
        }
        return ans;
    }


}
