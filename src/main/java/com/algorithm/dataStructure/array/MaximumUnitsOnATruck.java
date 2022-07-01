package com.algorithm.dataStructure.array;

import java.util.*;

/**
 * 1710. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 * <p>
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 * <p>
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author dragonsong  @date 2022/7/1
 */
public class MaximumUnitsOnATruck {

    /**
     * 执行用时：
     * 17 ms
     * , 在所有 Java 提交中击败了
     * 19.52%
     * 的用户
     * 内存消耗：
     * 41.9 MB
     * , 在所有 Java 提交中击败了
     * 21.45%
     * 的用户
     * 通过测试用例：
     * 76 / 76
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> unitNum2BoxNum = new TreeMap<>(Comparator.reverseOrder());
        /*
         *  numberOfBoxesi 是类型 i 的箱子的数量。
         *  numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
         */
        for (int[] boxType : boxTypes) {
            unitNum2BoxNum.put(boxType[1], unitNum2BoxNum.getOrDefault(boxType[1], 0) + boxType[0]);
        }
        int maxUnit = 0;
        for (Map.Entry<Integer, Integer> entry : unitNum2BoxNum.entrySet()) {
            if (truckSize == 0) {
                break;
            }

            Integer unitNum = entry.getKey();
            Integer boxNum = entry.getValue();
            int roundBoxNum = truckSize >= boxNum ? boxNum : truckSize;
            maxUnit += unitNum * roundBoxNum;
            truckSize -= roundBoxNum;
        }
        return maxUnit;
    }

    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 93.23%
     * 的用户
     * 内存消耗：
     * 42 MB
     * , 在所有 Java 提交中击败了
     * 16.93%
     * 的用户
     * 通过测试用例：
     * 76 / 76
     */
    public int maximumUnitsWithHeap(int[][] boxTypes, int truckSize) {
        Queue<int[]> unitNum2BoxNum = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        /*
         *  numberOfBoxesi 是类型 i 的箱子的数量。
         *  numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
         */
        for (int[] boxType : boxTypes) {
            unitNum2BoxNum.offer(boxType);
        }
        int maxUnit = 0;
        while (!unitNum2BoxNum.isEmpty()) {
            int[] boxType = unitNum2BoxNum.poll();
            if (truckSize == 0) {
                break;
            }

            int unitNum = boxType[1];
            int boxNum = boxType[0];
            int roundBoxNum = truckSize >= boxNum ? boxNum : truckSize;
            maxUnit += unitNum * roundBoxNum;
            truckSize -= roundBoxNum;
        }
        return maxUnit;
    }

    /**
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 64.84%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 53.39%
     * 的用户
     * 通过测试用例：
     * 76 / 76
     */
    public int maximumUnitsWithSort(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        /*
         *  numberOfBoxesi 是类型 i 的箱子的数量。
         *  numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
         */
        int maxUnit = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize == 0) {
                break;
            }

            int roundBoxNum = Math.min(truckSize, boxType[0]);
            maxUnit += boxType[1] * roundBoxNum;
            truckSize -= roundBoxNum;
        }
        return maxUnit;
    }
}
