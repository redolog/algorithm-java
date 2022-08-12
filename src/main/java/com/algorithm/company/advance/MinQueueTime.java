package com.algorithm.company.advance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * 函数应该返回一个整数，来表示所有顾客结账完所需的时间。
 * <p>
 * 提示
 * 多个收银台对应一个队列
 * <p>
 * 队列的顺序永远不变，且
 * <p>
 * 队列中最前面的人（即第一个元素）在收银台空闲时就会开始结账
 * <p>
 * 假设所有的测试输入都是有效的
 * <p>
 * 请看下面的例子和说明，以确保你正确理解这个任务。
 * <p>
 * 示例
 * queueTime([5,3,4], 1)
 * // 返回 12
 * // 因为当只有 1 个收银台时，总时间就是数组中的数字之和
 * <p>
 * queueTime([10,2,3,3], 2)
 * // 返回 10
 * // 有 2 个收银台，第 2 位、第 3 位和第 4 位顾客
 * // 会先于第 1 位顾客完成收银
 * <p>
 * queueTime([2,3,10], 2)
 * // 返回 12
 */
public class MinQueueTime {

    public int queueTime(int[] customers, int n) {
        // 时间复杂度 O(n)
        // 空间复杂度 O(1)
        // 排队人数少于队列数，取单人排队最长时间
        if (customers.length < n) {
            return Arrays.stream(customers).max().getAsInt();
        }
        // 只有一个队伍时，直接求和
        if (n == 1) {
            return Arrays.stream(customers).sum();
        }
        // 时间复杂度 O(n*logn)
        // 空间复杂度 O(n)
        // 人数大于队列数时，使用树结构模拟
        NavigableSet<Integer> set = new TreeSet<>(Comparator.naturalOrder());
        for (int customer : customers) {
            // 队没排满时直接入队
            if (set.size() < n) {
                set.add(customer);
            } else {
                // 队排满了，取当前队列排队时长最短的，更新时间
                Integer min = set.pollFirst();
                set.add(min + customer);
            }
        }
        return set.last();
    }
}
