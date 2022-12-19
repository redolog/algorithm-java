package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/reverse-vowels-of-a-string/
 *
 * @author songhuilong001  @date 2022/12/11
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] arr = s.toCharArray();
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            while (l < n && !vowels.contains(arr[l])) {
                l++;
            }
            while (r > 0 && !vowels.contains(arr[r])) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(arr, l, r);
            l++;
            r--;
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        char tmpL = arr[l];
        arr[l] = arr[r];
        arr[r] = tmpL;
    }
}
