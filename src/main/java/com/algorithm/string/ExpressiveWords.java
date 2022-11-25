package com.algorithm.string;

/**
 * https://leetcode.cn/problems/expressive-words/
 *
 * @author songhuilong001  @date 2022/11/25
 */
public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (stretchy(word, s)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * i表示遍历下标，n表示长度，cnt表示count计数
     * 对于一个给定的字符串 big ，如果另一个单词能够通过将一些字母组扩张从而使其和 big 相同，我们将这个单词定义为可扩张的（stretchy）
     *
     * @param word 待扩张的单词
     * @param big  已扩张的大单词
     * @return 如果 word 可以扩张为 big，则返回true，否则返回false
     */
    private boolean stretchy(String word, String big) {
        // wi/bi 分别指向 word/big 字符下标
        int wn = word.length(), bn = big.length(), wi = 0, bi = 0;
        if (bn < wn) {
            return false;
        }
        while (bi < bn) {
            if (wi == wn) {
                return false;
            }
            char wc = word.charAt(wi), bc = big.charAt(bi);
            if (wc != bc) {
                return false;
            }
            int wCnt = 1, bCnt = 1;
            while (wi + 1 < wn && word.charAt(wi + 1) == wc) {
                wCnt++;
                wi++;
            }
            while (bi + 1 < bn && big.charAt(bi + 1) == bc) {
                bCnt++;
                bi++;
            }
            if (wCnt == bCnt || (bCnt > wCnt && bCnt >= 3)) {
                wi++;
                bi++;
                continue;
            }
            return false;
        }
        return wi == wn;
    }
}
