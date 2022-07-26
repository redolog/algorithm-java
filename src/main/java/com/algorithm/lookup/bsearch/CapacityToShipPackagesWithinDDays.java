package com.algorithm.lookup.bsearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 * <p>
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 *
 * @author dragonsong  @date 2022/7/26
 */
public class CapacityToShipPackagesWithinDDays {

    /*
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 86.08%
     * 的用户
     * 内存消耗：
     * 45 MB
     * , 在所有 Java 提交中击败了
     * 39.40%
     * 的用户
     * 通过测试用例：
     * 85 / 85
     */

    public int shipWithinDays(int[] weights, int days) {
        // 负载边界
        int low = 0, high = 0;
        // 最小载重为商品重量中最大值；最大载重为所有商品重量和
        for (int weight : weights) {
            low = Math.max(weight, low);
            high += weight;
        }

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int daysNeed = daysByLoad(mid, weights);
            if (daysNeed <= days) {
                // 收缩右边界
                high = mid;
            } else {
                // 负载太小了，收缩左边界
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 负载->使用天数的递减函数
     *
     * @param load    船的负载能力
     * @param weights 货物重量数组
     * @return load所需运输完的天数
     */
    private int daysByLoad(int load, int[] weights) {
        int days = 1;
        int loadLoop = load;
        for (int weight : weights) {
            if (weight > loadLoop) {
                // 新的一天，重新装船
                days++;
                loadLoop = load;
            }
            loadLoop -= weight;
        }
        return days;
    }

}
