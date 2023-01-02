package com.algorithm.dataStructure.queue.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 *
 * @author songhuilong001  @date 2023/1/2
 */
public class NumberOfOrdersInTheBacklog {

    /**
     * 理解题干，发现每一轮匹配订单时，需要快速定位到购买积压的最大价格、销售积压的最小价格，可以考虑使用堆、树的结构进行过程模拟。
     * btw，匹配订单时，需一次匹配最多能成交的量，否则时间复杂度会较大。
     * 时间：O(n*logn)
     * 空间：O(n)
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        // 销售最小堆
        Queue<int[]> sellMinHeap = new PriorityQueue<>(Comparator.comparingInt(order -> order[0]));
        // 购买最大堆
        Queue<int[]> buyMaxHeap = new PriorityQueue<>((order1, order2) -> order2[0] - order1[0]);

        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                // 购买订单
                // 待购买数大于0 && 销售最低价小于等于购买价（购买能省钱）
                while (amount > 0 && !sellMinHeap.isEmpty() && sellMinHeap.peek()[0] <= price) {
                    int[] sellMinOrder = sellMinHeap.poll();
                    int sellBacklogAmount = sellMinOrder[1];
                    // 成交匹配数
                    int dealAmount = Math.min(sellBacklogAmount, amount);

                    sellBacklogAmount -= dealAmount;
                    if (sellBacklogAmount > 0) {
                        sellMinOrder[1] = sellBacklogAmount;
                        sellMinHeap.offer(sellMinOrder);
                    }
                    amount -= dealAmount;
                    order[1] = amount;
                }
                // 没买完，存入购买单积压队列
                if (amount > 0) {
                    buyMaxHeap.offer(order);
                }
            } else {
                // 销售订单
                // 待销售数大于0 && 购买最高价大于等于销售价（销售能赚钱）
                while (amount > 0 && !buyMaxHeap.isEmpty() && buyMaxHeap.peek()[0] >= price) {
                    int[] buyMaxOrder = buyMaxHeap.poll();
                    int buyBacklogAmount = buyMaxOrder[1];
                    int dealAmount = Math.min(buyBacklogAmount, amount);
                    buyBacklogAmount -= dealAmount;
                    if (buyBacklogAmount > 0) {
                        buyMaxOrder[1] = buyBacklogAmount;
                        buyMaxHeap.offer(buyMaxOrder);
                    }
                    amount -= dealAmount;
                    order[1] = amount;
                }
                // 没卖完，存入销售积压队列
                if (amount > 0) {
                    sellMinHeap.offer(order);
                }
            }
        }
        // 最后求解积压订单amount总和
        int ans = 0;
        for (int[] buyBacklogOrder : buyMaxHeap) {
            ans = (ans + buyBacklogOrder[1]) % 1000000007;
        }
        for (int[] sellBacklogOrder : sellMinHeap) {
            ans = (ans + sellBacklogOrder[1]) % 1000000007;
        }
        return ans;
    }
}
