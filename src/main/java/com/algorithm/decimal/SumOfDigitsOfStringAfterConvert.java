package com.algorithm.decimal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 *
 * @author DragonSong  @date 2022/10/15
 */
public class SumOfDigitsOfStringAfterConvert {

    public int getLucky(String s, int k) {
        Deque<Integer> digits = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'a' + 1;
            if (digit >= 10) {
                digits.add(digit / 10);
                digits.add(digit % 10);
            } else {
                digits.add(digit);
            }
        }
        int ans = -1;
        for (int i = 0; i < k; i++) {
            int sum = digits.stream().reduce(Integer::sum).orElse(-1);
            ans = sum;
            digits.clear();
            while (sum > 0) {
                digits.offerFirst(sum % 10);
                sum /= 10;
            }
        }
        return ans;
    }
}
