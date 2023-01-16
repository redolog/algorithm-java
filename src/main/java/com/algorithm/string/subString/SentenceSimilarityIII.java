package com.algorithm.string.subString;

/**
 * https://leetcode.cn/problems/sentence-similarity-iii/
 *
 * @author songhuilong  @date 2023/1/16
 */
public class SentenceSimilarityIII {

    /**
     * 判断小的句子能否拼接为大的句子
     * 正例：
     * 1. 中间插入
     * 2. 右侧或左侧插入
     * <p>
     * 反例：
     * 1. 两头插入
     * <p>
     * 特例：
     * 1. sentence1.equals(sentence2)
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 == n2) {
            return sentence1.equals(sentence2);
        }
        int nLesser, nGreater;
        String[] arrLesser, arrGreater;
        if (n1 < n2) {
            nLesser = n1;
            nGreater = n2;
            arrLesser = arr1;
            arrGreater = arr2;
        } else {
            nLesser = n2;
            nGreater = n1;
            arrLesser = arr2;
            arrGreater = arr1;
        }

        // 短句头、尾 既不在长句头、尾，肯定不符合题干
        if (!arrLesser[0].equals(arrGreater[0]) && !arrLesser[0].equals(arrGreater[nGreater - 1])
                && !arrLesser[nLesser - 1].equals(arrGreater[0]) && !arrLesser[nLesser - 1].equals(arrGreater[nGreater - 1])) {
            return false;
        }
        // 短句只有一个词
        if (nLesser == 1) {
            return true;
        }
        int lLesser = 0, rLesser = nLesser - 1, lGreater = 0, rGreater = nGreater - 1;
        while (lLesser <= rLesser) {
            if (arrLesser[lLesser].equals(arrGreater[lGreater])) {
                lLesser++;
                lGreater++;
                continue;
            }
            if (arrLesser[rLesser].equals(arrGreater[rGreater])) {
                rLesser--;
                rGreater--;
                continue;
            }
            return false;
        }
        return true;
    }
}
