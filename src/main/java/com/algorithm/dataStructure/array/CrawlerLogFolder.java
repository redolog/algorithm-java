package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/crawler-log-folder/
 *
 * @author DragonSong  @date 2022/9/9
 */
public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        int ans = 0;

        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            }

            if (ans != 0 && "../".equals(log)) {
                ans -= 1;
            }

            if (!"../".equals(log)) {
                ans++;
            }
        }

        return ans;
    }
}
