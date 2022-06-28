package com.algorithm.dataStructure.skiplist;

public class SkipListLevelUtils {
    /**
     * 最大层数
     */
    public static final int MAX_LEVEL = 16;
    /**
     * 初始层
     */
    public static final int MIN_LEVEL = 1;
    /**
     * 生成下一层的概率
     */
    private static final double DEFAULT_PROBABILITY = 0.5;

    /**
     * 1层概率为 DEFAULT_PROBABILITY
     * 2层概率为 DEFAULT_PROBABILITY^2
     * n层概率为 DEFAULT_PROBABILITY^n
     * 越上层，生成概率越低，分母指数级上升
     *
     * @return level范围为 [MIN_LEVEL,MAX_LEVEL) 左闭右开
     */
    public static int genRandomLevel() {
        int level = MIN_LEVEL;
        while (Math.random() <= DEFAULT_PROBABILITY && level < MAX_LEVEL) {
            ++level;
        }
        return level;
    }
}
