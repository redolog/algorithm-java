package com.algorithm.dataStructure.array.traverse;

/**
 * 243. 最短单词距离
 * 给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出: 1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] 由小写英文字母组成
 * word1 和 word2 在 wordsDict 中
 * word1 != word2
 * <p>
 * https://leetcode.cn/problems/shortest-word-distance/
 *
 * @author dragonsong  @date 2022/7/29
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;
        // word1、word2对应下标位置
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            // 出现word1、word2时，更新最新位置
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
            } else if (wordsDict[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 >= 0 && idx2 >= 0) {
                ans = Math.min(ans, Math.abs(idx1 - idx2));
            }
        }
        return ans;
    }

}
