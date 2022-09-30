package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reformat-phone-number/
 *
 * @author DragonSong  @date 2022/10/1
 */
public class ReformatPhoneNumber {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public String reformatNumber(String number) {
        StringBuilder builder = new StringBuilder();
        // 去空格、-
        for (char c : number.toCharArray()) {
            if (c == ' ' || c == '-') {
                continue;
            }
            builder.append(c);
        }
        // 分块
        List<String> blocks = new ArrayList<>();
        int i = 0;
        // 三个为一块
        while (i < builder.length()) {
            // 当前剩余超过四个，优先取三个一组
            if (builder.length() - 1 - i + 1 > 4) {
                blocks.add(builder.substring(i, i + 3));
                i += 3;
            } else if (builder.length() - 1 - i + 1 == 4) {
                // 4个数，分为2+2
                blocks.add(builder.substring(i, i + 2));
                blocks.add(builder.substring(i + 2, i + 4));
                i += 4;
            } else if (builder.length() - 1 - i + 1 == 3) {
                // 3个数
                blocks.add(builder.substring(i, i + 3));
                i += 3;
            } else {
                // ==2 ，此时只能取两个一组
                blocks.add(builder.substring(i, i + 2));
                i += 2;
            }
        }
        builder.delete(0, builder.length());
        for (int j = 0; j < blocks.size() - 1; j++) {
            builder.append(blocks.get(j)).append("-");
        }
        builder.append(blocks.get(blocks.size() - 1));
        return builder.toString();
    }
}
