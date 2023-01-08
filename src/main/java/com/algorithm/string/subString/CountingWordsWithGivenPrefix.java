package com.algorithm.string.subString;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
 *
 * @author songhuilong001  @date 2023/1/8
 */
public class CountingWordsWithGivenPrefix {

    static class StreamSolution {
        public int prefixCount(String[] words, String pref) {
            return (int) Arrays.stream(words)
                    .filter(word -> word.startsWith(pref))
                    .count();
        }
    }

    static class TwoPointerSolution {
        public int prefixCount(String[] words, String pref) {
            int cnt = 0;
            for (String word : words) {
                if (startWith(word, pref)) {
                    cnt++;
                }
            }
            return cnt;
        }

        private boolean startWith(String word, String pref) {
            // 遍历 word、pref的指针
            for (int wi = 0, pi = 0; pi < pref.length(); pi++, wi++) {
                if (wi >= word.length() || word.charAt(wi) != pref.charAt(pi)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 特里树版本，解决此题略显复杂
     * 空间：O(n)
     * 时间：O(n)
     */
    static class TrieSolution {
        public int prefixCount(String[] words, String pref) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            return trie.calcPrefixFreq(pref);
        }

        static class Trie {

            /**
             * 当前节点字符表示
             */
            char c;
            /**
             * 下级词字符
             */
            Trie[] children;
            /**
             * 是否为结束点
             */
            boolean stop;
            /**
             * 当前节点词频
             */
            int freq;

            public Trie() {
                // root
                children = new Trie[26];
            }

            private static boolean strEmpty(String str) {
                return str == null || str.length() == 0;
            }

            public void insert(String word) {
                if (strEmpty(word)) {
                    return;
                }
                char[] wordArr = word.toCharArray();
                Trie curr = this;
                for (int i = 0; i < wordArr.length; i++) {
                    char c = wordArr[i];
                    int charIdx = c - 'a';
                    if (curr.children[charIdx] == null) {
                        Trie node = new Trie();
                        node.c = c;
                        curr.children[charIdx] = node;
                    }
                    if (i == wordArr.length - 1) {
                        curr.children[charIdx].stop = true;
                    }
                    curr.children[charIdx].freq++;
                    curr = curr.children[charIdx];
                }
            }

            public boolean search(String word) {
                if (strEmpty(word)) {
                    return false;
                }
                Trie lastNode = searchPrefixLastNode(word);
                return lastNode != null && lastNode.stop;
            }

            public boolean startsWith(String prefix) {
                if (strEmpty(prefix)) {
                    return false;
                }
                Trie lastNode = searchPrefixLastNode(prefix);
                return lastNode != null;
            }

            private Trie searchPrefixLastNode(String prefix) {
                char[] wordArr = prefix.toCharArray();
                Trie curr = this;
                for (char c : wordArr) {
                    int charIdx = c - 'a';
                    if (curr == null || curr.children == null || curr.children[charIdx] == null) {
                        return null;
                    }
                    if (c != curr.children[charIdx].c) {
                        return null;
                    }
                    curr = curr.children[charIdx];
                }
                return curr;
            }

            public int calcPrefixFreq(String prefix) {
                if (strEmpty(prefix)) {
                    return 0;
                }
                Trie curr = this;
                for (int i = 0; i < prefix.length(); i++) {
                    int charIdx = prefix.charAt(i) - 'a';
                    if (curr == null || curr.children == null || curr.children[charIdx] == null) {
                        return 0;
                    }
                    curr = curr.children[charIdx];
                }
                return curr.freq;
            }
        }
    }
}
