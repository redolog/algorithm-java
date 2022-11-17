package com.algorithm.dataStructure.matrix;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2363. 合并相似的物品
 * https://leetcode.cn/problems/merge-similar-items/
 *
 * @author songhuilong  @date 2022/11/17
 */
public class MergeSimilarItems {

    static class MapSolution {
        /**
         * map计数排序，使用TreeMap
         * 时间：O(n*logn)
         * 空间：O(n)
         */
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Map<Integer, Integer> value2Weight = new TreeMap<>(Comparator.naturalOrder());
            for (int[] item : items1) {
                value2Weight.put(item[0], item[1]);
            }
            for (int[] item : items2) {
                int value = item[0];
                value2Weight.put(value, value2Weight.getOrDefault(value, 0) + item[1]);
            }
            return value2Weight.entrySet().stream()
                    .map(entry -> new ArrayList<Integer>(2) {{
                        add(entry.getKey());
                        add(entry.getValue());
                    }})
                    .collect(Collectors.toList());
        }
    }

    static class SortTwoPointer {
        /**
         * 排序+双指针
         * 时间：O(n*logn)
         * 空间：O(1)，java中目测有空间开销，这里只分析理论空间效率
         */
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Arrays.sort(items1, Comparator.comparingInt(item -> item[0]));
            Arrays.sort(items2, Comparator.comparingInt(item -> item[0]));

            List<List<Integer>> ans = new ArrayList<>(Math.max(items1.length, items2.length));
            // curr指向当前value更小的数组，next指向另一个
            // i遍历curr，j遍历next
            int[][] currMatrix, nextMatrix;
            int currI = 0, nextI = 0;
            if (items1[0][0] <= items2[0][0]) {
                currMatrix = items1;
                nextMatrix = items2;
            } else {
                currMatrix = items2;
                nextMatrix = items1;
            }
            while (currI < currMatrix.length) {
                List<Integer> item = new ArrayList<>(2);
                int[] currItem = currMatrix[currI];
                int currVal = currItem[0];
                int currWeight = currItem[1], weightSum = currWeight;
                item.add(currVal);
                if (nextI < nextMatrix.length && nextMatrix[nextI][0] == currVal) {
                    weightSum += nextMatrix[nextI][1];
                    nextI++;
                }
                currI++;
                item.add(weightSum);
                ans.add(item);

                // 重新指定curr next
                if (currI < currMatrix.length && nextI < nextMatrix.length && currMatrix[currI][0] > nextMatrix[nextI][0]) {
                    int[][] currMatrixTmp = currMatrix;
                    currMatrix = nextMatrix;
                    nextMatrix = currMatrixTmp;

                    int currTmp = currI;
                    currI = nextI;
                    nextI = currTmp;
                }
            }
            while (nextI < nextMatrix.length) {
                List<Integer> item = new ArrayList<>(2);
                int[] currItem = nextMatrix[nextI];
                item.add(currItem[0]);
                item.add(currItem[1]);
                ans.add(item);
                nextI++;
            }
            return ans;
        }
    }
}
