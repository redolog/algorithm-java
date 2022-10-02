package com.algorithm.string;

/**
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 *
 * @author DragonSong  @date 2022/10/2
 */
public class SwapAdjacentInLrString {
    /**
     * 字符串中只包含 L R X
     * 可以用LX替换原来的XL，即L可以左移
     * 可以用XR替换原来的RX，即R可以右移
     * 限制：
     * - L左移不能跨越R（不构成XL了）
     * - R右移不能跨越L（不构成RX了）
     * <p>
     * <p>
     * 用例：
     * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
     * 输出: True
     * 解释:
     * 我们可以通过以下几步将start转换成end:
     * RXXLRXRXL ->
     * XRXLRXRXL ->
     * XRLXRXRXL ->
     * XRLXXRRXL ->
     * XRLXXRRLX
     * <p>
     * <p>
     * 输入: start = "XXXXXLXXXX", end = "LXXXXXXXXX"
     * 输出: True
     * 解释:
     * 我们可以通过以下几步将start转换成end:
     * XXXXXLXXXX ->
     * XXXXLXXXX ->
     * XXXLXXXX ->
     * XXLXXXX ->
     * XLXXXX
     * LXXXX
     * <p>
     * 根据用例分析+一些错误尝试，总结该算法过程：
     * - start、end上同步查找除了x之外的字符
     * - 如果停下时二者不等，说明无法转换成功
     * - 停下时L时，e>s，说明end串L更右，无法左移成功
     * - 停下时R时，e<s，说明end串R更左，无法右移成功
     * <p>
     * 时间复杂度：完整遍历字符串长度，O(n)
     * 空间复杂度：只有 s/e 指针开销，O(1)
     */
    public boolean canTransform(String start, String end) {
        // n表示串长度；s表示start遍历位置；e表示end遍历位置
        int n = start.length(), s = 0, e = 0;
        while (s < n && e < n) {
            // s查找 L、R
            while (s < n && start.charAt(s) == 'X') {
                s++;
            }
            // e查找 L、R
            while (e < n && end.charAt(e) == 'X') {
                e++;
            }
            // 有一个串已经匹配完了，到外部看看剩下的串是否都是X
            if (s == n || e == n) {
                break;
            }

            // 找到的当前l、r不相等，死局
            if (start.charAt(s) != 'X' && end.charAt(e) != 'X') {
                if (start.charAt(s) != end.charAt(e)) {
                    // 当前位置两个字符不匹配，肯定无法转换
                    return false;
                }
                // 到了这里，说明俩字符匹配，但是由用例 ("LXXLXRLXXL", "XLLXRXLXLX") 可得：L只能左移，不能右移！同理R只能右移，不能左移！
                if (start.charAt(s) == 'L' && e > s) {
                    // L字符，end更靠右，也就是L是无法通过左移往右！
                    return false;
                }
                if (start.charAt(s) == 'R' && e < s) {
                    // R字符，end更靠左，也就是是无法通过右移往左！
                    return false;
                }
            }
            s++;
            e++;
        }
        // s没走完，剩下只能都是X
        while (s < n) {
            if (start.charAt(s++) != 'X') {
                return false;
            }
        }
        // e没走完，剩下只能都是X
        while (e < n) {
            if (end.charAt(e++) != 'X') {
                return false;
            }
        }
        return s == e;
    }

}
