package com.algorithm.string;

/**
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * @author dragonsong  @date 2022/8/21
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = 0;
        for (String word : sentence.split(" ")) {
            ans++;
            if (isPrefix(word, searchWord)) {
                return ans;
            }
        }
        return -1;
    }

    private boolean isPrefix(String word, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (i >= word.length() || word.charAt(i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
