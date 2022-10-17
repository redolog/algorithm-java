package com.algorithm.dataStructure.array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/fruit-into-baskets/
 *
 * @author songhuilong  @date 2022/10/17
 */
public class FruitsIntoBaskets {

    /**
     * 记录当前已经放入篮子的水果种类、量
     * 记录当前篮子水果总量
     * ans为水果总量最大值
     * <p>
     * 使用窗口维护、记录当前篮子中是否超过两种水果，超过则丢弃左侧水果（因为只能连续拿水果），不超过则更新已有水果量、总量
     * 同时更新ans
     * <p>
     * 时间复杂度：极端情况下几乎所有数据出入窗口一次，O(n)
     * 空间复杂度：只占用常数空间，O(1)
     */
    public int totalFruit(int[] fruits) {
        int ans = 2, n = fruits.length
                // 初始我们往篮子中放入前两个水果
                , sum = 2
                // l、r表示窗口左右边界
                , l = 0, r = 0;
        if (n < 2) {
            return n;
        }
        // 记录当前篮子中的类型+对应个数
        Map<Integer, Integer> type2Cnt = new HashMap<>(3);
        for (; r < n; r++) {
            int type = fruits[r];
            if (r < 2) {
                // fruits[0]/fruits[1] 初始到map
                type2Cnt.put(type, type2Cnt.getOrDefault(type, 0) + 1);
                continue;
            }

            // 0/1之后的水果
            if (type2Cnt.containsKey(type)) {
                // 新的水果应在篮子内，更新计数
                type2Cnt.put(type, type2Cnt.get(type) + 1);
                sum++;

            } else {
                if (type2Cnt.keySet().size() == 2) {
                    // 新的水果品种不在篮子内 && 篮子里已经装了两类水果，将l左侧的水果拿出篮子
                    int removeLType = fruits[l];
                    // 一直删，直到给新的水果空出一个位子
                    while (l < r && type2Cnt.keySet().size() == 2) {
                        l++;
                        int newCnt = type2Cnt.getOrDefault(removeLType, 0) - 1;
                        if (newCnt == 0) {
                            type2Cnt.remove(removeLType);
                        } else {
                            type2Cnt.put(removeLType, newCnt);
                        }
                        sum--;
                        // 此处也需要更新l
                        removeLType = fruits[l];
                    }
                }
                // 装新的水果
                type2Cnt.put(type, 1);
                sum++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
