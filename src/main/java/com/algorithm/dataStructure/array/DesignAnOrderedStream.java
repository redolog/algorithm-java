package com.algorithm.dataStructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/design-an-ordered-stream/
 *
 * @author dragonsong  @date 2022/8/16
 */
public class DesignAnOrderedStream {
    /**
     * 这道题很神奇，中英文的题干好多人评论读不懂，我尝试读了好几遍，确实读不懂
     * 根据动图，我模拟了程序过程，因此本题不贴题干了。
     */

    static class OrderedStream {

        int readIdx;

        String[] arr;

        public OrderedStream(int n) {
            arr = new String[n];
            readIdx = 0;
        }

        /**
         * 按 idKey插入对应value，当前读取下标有值时，开始读取，直到一个没有值的位置
         */
        public List<String> insert(int idKey, String value) {
            arr[idKey - 1] = value;
            List<String> list = new ArrayList<>();
            while (readIdx < arr.length && arr[readIdx] != null) {
                list.add(arr[readIdx++]);
            }
            return list;
        }
    }
}
