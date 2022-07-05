package com.algorithm.bytedance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字节面试：
 * <p>
 * 题目描述
 * 已知一天内用户登录登出的日志（数据量较大），求这一天用户在线的最大峰值和持续时长​
 * - 日志包含字段（userid, login_time, logout_time）​
 * - 登录登出时间精确到秒
 *
 * @author dragonsong  @date 2022/7/5
 */
public class CalculateActiveUserPeakAndLastingTime {

    public int[] calculateActiveUserPeakAndLastingTime(Log[] logs) {
        // 上线时刻-》人数
        Map<Integer, Integer> loginTime2Cnt = new LinkedHashMap<>();
        // 下线时刻-》人数
        Map<Integer, Integer> logoutTime2Cnt = new LinkedHashMap<>();
        // O(n)
        for (Log log : logs) {
            int loginTime = log.loginTime;
            loginTime2Cnt.put(loginTime, loginTime2Cnt.getOrDefault(loginTime, 0) + 1);
            int logoutTime = log.logoutTime;
            logoutTime2Cnt.put(logoutTime, logoutTime2Cnt.getOrDefault(logoutTime, 0) + 1);
        }
        // 所有时刻
        Set<Integer> secondSet = loginTime2Cnt.keySet();
        secondSet.addAll(logoutTime2Cnt.keySet());

        // O(n)
        // 当前时刻在线人数 = 上一秒在线人数 - 当前秒下线人数 + 当前秒上线人数
        Map<Integer, Integer> second2Cnt = new LinkedHashMap<>();
        for (Integer second : secondSet) {
            Integer loginCnt = loginTime2Cnt.getOrDefault(second, 0);
            Integer logoutCnt = logoutTime2Cnt.getOrDefault(second, 0);
            second2Cnt.put(second, second2Cnt.getOrDefault(second - 1, 0) - logoutCnt + loginCnt);
        }
        int[] ans = new int[2];
        Integer activeUserPeak = second2Cnt.values().stream().max(Comparator.comparingInt(i -> i)).orElse(0);
        ans[0] = activeUserPeak;

        int maxCnt = 0;
        List<Integer> activeUserPeakSeconds = second2Cnt.entrySet().stream().filter(entry -> entry.getValue().equals(activeUserPeak)).map(Map.Entry::getKey).collect(Collectors.toList());

        // O(n)
        for (int i = 0; i < activeUserPeakSeconds.size(); ) {
            int j = i;
            int groupSeconds = 1;
            for (; j < activeUserPeakSeconds.size(); j++) {
                if (continuous(activeUserPeakSeconds.get(i), activeUserPeakSeconds.get(i + 1))) {
                    groupSeconds++;
                } else {
                    break;
                }
            }
            maxCnt = Math.max(maxCnt, groupSeconds);
            i = j;
        }
        ans[1] = maxCnt;
        return ans;
    }

    private boolean continuous(int i, int j) {
        return i == j + 1 || i == j - 1;
    }

    static class Log {
        int userId;

        int loginTime;

        int logoutTime;
    }
}
