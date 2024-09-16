package com.algorithm.greedy;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 题目描述：
 * 限制：每辆车可以装载最大300的货物
 * 给定一个int[]，weights [100,300]范围，每个元素表示货物重量的数组
 * 求装完给定货物最少的车辆数
 *
 * @author songhuilong  @date 2024/9/16
 */
public class FindMinimumQuantityOfCars {

    // 整体思路：贪心算法，每一辆车尽可能的往里面装入能装得下的最大的货物

    /**
     * 使用有序集合（树、跳表）的方案思路：
     * 1. 使用红黑树记录每个重量对应的货物数量；
     * 2. 每辆车从当前剩余
     */
    public static class BinarySearchCollectionSolution {
        /**
         * 整体复杂度：O(n*logn)
         * 限制：每辆车可以装载最大300的货物
         *
         * @param weights [100,300]范围，每个元素表示货物重量的数组
         * @return 求装完给定货物最少的车辆数
         */
        public int findMinimumQuantityOfCars(int[] weights) {
            int ans = 0;
            // 每个重量的货 对应 数量
            TreeMap<Integer, Integer> weight2Count = new TreeMap<>(Comparator.naturalOrder());
            // 树形成复杂度 O(n*logn)
            for (int weight : weights) {
                weight2Count.put(weight, weight2Count.getOrDefault(weight, 0) + 1);
            }
            // 每辆车先选中一个当前最大的货，重量x，然后去找小于且最接近(当前剩余容量-x)的货，如果此时(当前剩余容量-x)小于100则装下一辆
            // 每一轮选中某个货物后，从treemap有序结构中移除货物计数

            while (true) {
                if (weight2Count.size() == 0) {
                    break;
                }
                // 从最重的货物开始装
                // 获取最大值复杂度 O(1)
                Integer maxWeight = weight2Count.lastKey();
                // 更新最重货物量
                updateTargetWeightCount(weight2Count, maxWeight);

                if (weight2Count.size() == 0) {
                    break;
                }
                int remainWeight = 300 - maxWeight;
                while (weight2Count.size() > 0 && weight2Count.firstKey() <= remainWeight) {
                    // 这里使用树形结构查询，二分法复杂度 O(logn)
                    Integer maxLowerWeight = weight2Count.floorKey(remainWeight);
                    // 更新 小于且最接近(当前剩余容量-x)的货量
                    updateTargetWeightCount(weight2Count, maxLowerWeight);
                    remainWeight -= maxLowerWeight;
                }
                ans++;
            }
            return ans;
        }

        // 更新某个key O(1)
        private void updateTargetWeightCount(TreeMap<Integer, Integer> weight2Count, Integer maxLowerWeight) {
            Integer maxLowerWeightCount = weight2Count.get(maxLowerWeight);
            if (maxLowerWeightCount - 1 > 0) {
                weight2Count.put(maxLowerWeight, maxLowerWeightCount - 1);
            } else {
                weight2Count.remove(maxLowerWeight);
            }
        }
    }

    /**
     * 观察题目给定的条件，发现货物重量区间为 [100, 300]，是一个常数级别的区间，因此我们可以尝试两个操作：
     * 1. 给定的重量排序，可以使用桶排序，排序的复杂度能达到O(n)，要优于快排这种方案；
     * 2. 每辆车去找当前能装得下的最大货物时，可直接遍历查找（因为逐个遍历也就是O(201)的复杂度，是一个常数级复杂度）；
     */
    public static class BucketSortSolution {

        public int findMinimumQuantityOfCars(int[] weights) {
            // 排序后的桶，维护货物重量->货物数量
            // 复杂度：O(n)
            // 一共n个货物
            int bucketN = 300 - 100 + 1;
            int[] weight2Cnt = new int[bucketN];
            for (int weight : weights) {
                weight2Cnt[weight - 100]++;
            }

            int ans = 0;
            while (true) {
                // 标记当前车辆有无货物可装，一辆车最多装3个货
                int carWeightCnt = 3;
                // 当前车辆剩余可装容量
                int remainWeight = 300;
                // 每辆车尽可能装满
                // 从大的货物开始装
                for (int i = remainWeight - 100; i >= 0; i--) {
                    int currWeight = i + 100;
                    if (remainWeight < currWeight || weight2Cnt[i] == 0) {
                        // 当前货物太重了，看下一个比较轻的
                        // 当前重量没有货物
                        continue;
                    }
                    while (remainWeight >= currWeight && weight2Cnt[i] > 0) {
                        remainWeight -= currWeight;
                        weight2Cnt[i]--;
                        carWeightCnt--;
                    }
                }
                if (carWeightCnt == 3) {
                    // 已经没有货物了
                    break;
                }
                ans++;
            }
            return ans;
        }
    }

}
