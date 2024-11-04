package com.algorithm.dataStructure.array.majorityElement;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <a href="https://leetcode.cn/problems/majority-element-ii/description/">229. 多数元素 II</a>
 *
 * @author songhuilong  @date 2024/11/4
 */
public class MajorityElementII {

    public static class MapCntSolution {
        public List<Integer> majorityElement(int[] nums) {
            Map<Integer, Integer> num2Cnt = new HashMap<>();
            for (int num : nums) {
                num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
            }
            List<Integer> ans = new LinkedList<>();
            int n = nums.length;
            for (Map.Entry<Integer, Integer> entry : num2Cnt.entrySet()) {
                if (entry.getValue() > n / 3) {
                    ans.add(entry.getKey());
                }
            }
            return ans;
        }
    }

    public static class MooreVoteSolution {

        public List<Integer> majorityElement(int[] nums) {
            int n = nums.length;
            int k = 3;
            // 维护 集合中多于 n/k 个数的众数频次
            // 众数一定少于k-1个
            Map<Integer, Integer> major2Cnt = new HashMap<>();
            // 摩尔投票的思想：逐个遍历入参集合中的元素；
            // 1. 判断 major2Cnt 是否达到 k-1 个，没达到则直接计入当前元素；
            // 2. 判断每个数是否存在于 major2Cnt 中，如不存在，则抵消 major2Cnt 中所有元素，计数-1
            // 3. 最后 major2Cnt 剩下的一定是满足题目的众数

            for (int num : nums) {
                if (major2Cnt.size() < (k - 1)) {
                    major2Cnt.put(num, major2Cnt.getOrDefault(num, 0) + 1);
                    continue;
                }
                if (major2Cnt.containsKey(num)) {
                    // 相同元素，则增加num的计数，放大优势
                    major2Cnt.put(num, major2Cnt.get(num) + 1);
                } else {
                    // num不在众数集合中，抵消众数集合中所有元素一次
                    // 抵消的元素有两种情况：
                    // 1. 被抵消的是众数，则在之后的处理中，众数保持优势，一直存在于众数集合中
                    // 2. 被抵消的是非众数，则在之后的处理中，众数占得集合席位
                    Iterator<Map.Entry<Integer, Integer>> iterator = major2Cnt.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Integer> entry = iterator.next();
                        int newCnt = entry.getValue() - 1;
                        Integer majorityNum = entry.getKey();
                        if (newCnt == 0) {
                            iterator.remove();
                        } else {
                            major2Cnt.put(majorityNum, newCnt);
                        }
                    }
                }
            }

            // 最后需要对k-1个元素检查出现次数
            // 占用k-1个空间
            Map<Integer, Integer> num2Cnt = new HashMap<>();
            for (int num : nums) {
                if (major2Cnt.containsKey(num)) {
                    num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : num2Cnt.entrySet()) {
                if (entry.getValue() > n / k) {
                    ans.add(entry.getKey());
                }
            }
            return ans;
        }
    }

}
