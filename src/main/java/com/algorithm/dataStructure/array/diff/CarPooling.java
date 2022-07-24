package com.algorithm.dataStructure.array.diff;

/**
 * 1094. 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 * <p>
 * https://leetcode.cn/problems/car-pooling/
 *
 * @author dragonsong  @date 2022/7/24
 */
public class CarPooling {

    static class DiffArr {
        public boolean carPooling(int[][] trips, int capacity) {
            // 原数组存储每个站实际载客人数，差分数组存每个站相比前站的增量
            int[] diff = new int[1001];
            for (int[] trip : trips) {
                int numPassengers = trip[0];
                int from = trip[1];
                int to = trip[2];
                diff[from] += numPassengers;
                if (to < 1001) {
                    diff[to] -= numPassengers;
                }
            }
            int maxLoad = diff[0];
            for (int i = 1; i < 1001; i++) {
                if (maxLoad > capacity) {
                    return false;
                }
                maxLoad += diff[i];
            }
            return true;
        }
    }
}
