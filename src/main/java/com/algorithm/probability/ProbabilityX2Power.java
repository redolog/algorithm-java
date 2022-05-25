package com.algorithm.probability;

/**
 * // 返回[0,1)的一个小数
 * // 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
 *
 * @author dragonsong  @date 2022/5/25
 */
public class ProbabilityX2Power {

    /**
     * 已知：Math.random() 等概率返回[0,1)的一个小数
     * <p>
     * 任意的x，x属于[0,1)，[0,x)范围上的数出现概率可分析得出为 x/1 即 x
     * <p>
     * 现在求一个新的函数，返回0-x 概率是x平方
     * <p>
     * 思路分析：
     * 原 random() 中出现两种情况：
     * 1. [0,x) 概率为 x
     * 2. [x,1) 概率为 1-x
     * <p>
     * 当我们调用 random() 两次时，出现情况的概率变为：
     * 1. [0,x) [0,x) x^2
     * 2. [0,x) [x,1) x*(1-x)
     * 3. [x,1) [0,x) x*(1-x)
     * 4. [x,1) [x,1) (1-x)^2
     * <p>
     * 在两次调用中，我们只取最大值，即将 2.3.情况统一归到4.中，
     * 此时 [0,x) 概率为 x^2，而其余情况为 1-x^2
     * <p>
     * 同理，我们也可以调用多次取最小值，此时 [0,x) 概率为 1-(1-x)^2
     *
     * @return 随机结果
     */
    public static double probabilityX2Power2() {
        return Math.max(Math.random(), Math.random());
    }


}
