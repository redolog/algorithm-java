package com.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/check-distances-between-same-letters/
 *
 * @author DragonSong  @date 2022/10/29
 */
public class CheckDistancesBetweenSameLetters {

    static class ArrSolution {
        public boolean checkDistances(String s, int[] distance) {
            int n = s.length();
            // 字符第一次出现时记录当前idx位置
            int[] prevIdxArr = new int[26];
            Arrays.fill(prevIdxArr, -1);
            // 倒序查找
            for (int i = 0; i < n; i++) {
                char currC = s.charAt(i);
                if (prevIdxArr[currC - 'a'] != -1) {
                    if (distance[currC - 'a'] != i - prevIdxArr[currC - 'a'] - 1) {
                        return false;
                    }
                } else {
                    prevIdxArr[currC - 'a'] = i;
                }
            }
            return true;
        }
    }

    static class MapSolution {
        public boolean checkDistances(String s, int[] distance) {
            int n = s.length();
            // 字符第一次出现时记录当前idx位置
            Map<Character, Integer> c2PrevIdx = new HashMap<>();
            // 倒序查找
            for (int i = 0; i < n; i++) {
                char currC = s.charAt(i);
                if (c2PrevIdx.containsKey(currC)) {
                    if (distance[currC - 'a'] != i - c2PrevIdx.get(currC) - 1) {
                        return false;
                    }
                } else {
                    c2PrevIdx.put(currC, i);
                }
            }
            return true;
        }
    }
}
