package com.algorithm.string;

/**
 * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
 * <p>
 * 请你返回完成这个过程所需要的秒数。
 *
 * @author dragonsong  @date 2022/8/20
 */
public class TimeNeededToRearrangeABinaryString {

    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            ans++;
        }
        return ans;
    }
}
