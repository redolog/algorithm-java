package com.algorithm.string;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/decode-the-message/
 *
 * @author songhuilong  @date 2023/2/1
 */
public class DecodeMessage {

    public String decodeMessage(String key, String message) {
        // 映射key字符对应解密字符偏移量
        int[] mapping = new int[26];
        Arrays.fill(mapping, -1);
        // j表示 [a-z] 偏移下标
        int j = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (mapping[c - 'a'] == -1) {
                mapping[c - 'a'] = j++;
            }
        }
        char[] arr = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                arr[i] = ' ';
            } else {
                arr[i] = (char) (mapping[c - 'a'] + 'a');
            }
        }
        return String.valueOf(arr);
    }
}
