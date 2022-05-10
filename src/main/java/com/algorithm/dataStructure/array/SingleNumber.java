package com.algorithm.dataStructure.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author dragonsong  @date 2022/5/10
 * @link {https://leetcode.cn/problems/single-number/}
 */
public class SingleNumber {

    /**
     * 答案是使用位运算。对于这道题，可使用异或运算 \oplus⊕。异或运算有以下三个性质。
     * <p>
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
     * 任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
     * 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     */
    public static int singleNumberXor(int[] nums) {
//        int single = 0;
//        for (int num : nums) {
//            single ^= num;
//        }
//        return single;

        // stream with extra memory cost
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).orElse(-1);
    }

    public static int singleNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static int singleNumberWithSetSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 原始数组和
        int originalSum = 0;
        for (int num : nums) {
            set.add(num);
            originalSum += num;
        }
        // 元素不重复的和
        Integer setSum = set.stream()
                .reduce(Integer::sum)
                .orElse(0);
        return originalSum - setSum * 2;
    }

}
