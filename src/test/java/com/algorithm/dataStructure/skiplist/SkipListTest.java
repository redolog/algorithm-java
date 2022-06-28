package com.algorithm.dataStructure.skiplist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SkipListTest {

    /**
     * {0=7973, 1=4055, 2=1949, 3=1012, 4=498, 5=245, 6=150, 7=67, 8=33, 9=18, 10=6, 11=4, 13=2, 15=2}
     * 0层出现概率：0.4983125
     * 1层出现概率：0.2534375
     * 2层出现概率：0.1218125
     * 3层出现概率：0.06325
     * 4层出现概率：0.031125
     * 5层出现概率：0.0153125
     * 6层出现概率：0.009375
     * 7层出现概率：0.0041875
     * 8层出现概率：0.0020625
     * 9层出现概率：0.001125
     * 10层出现概率：3.75E-4
     * 11层出现概率：2.5E-4
     * 13层出现概率：1.25E-4
     * 15层出现概率：1.25E-4
     */
    @Test
    public void genRandomLevelTest() {
        int cnt = 16000;

        Map<Integer, Integer> level2Cnt = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            int level = SkipListLevelUtils.genRandomLevel();
            level2Cnt.putIfAbsent(level, 1);
            level2Cnt.computeIfPresent(level, (k, v) -> v + 1);
        }

        System.out.println(level2Cnt);

        for (Map.Entry<Integer, Integer> entry : level2Cnt.entrySet()) {
            Integer level = entry.getKey();
            Integer levelCnt = entry.getValue();
            System.out.println(level + "层出现概率：" + (double) levelCnt / (double) cnt);
        }
    }
}