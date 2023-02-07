package com.algorithm.dataStructure.array.app.sort;

import java.util.*;

/**
 * https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 *
 * @author songhuilong  @date 2023/2/7
 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {

    /**
     * 空间：O(n)
     * 时间：O(n*logn)
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> name2Times = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            name2Times.putIfAbsent(name, new ArrayList<>());
            List<Integer> times = name2Times.get(name);
            times.add(hhmm2Minutes2(keyTime[i]));
        }

        List<String> ansList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : name2Times.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            int timeCnt = times.size();
            if (timeCnt < 3) {
                continue;
            }
            times.sort(Comparator.naturalOrder());

            for (int l = 0, r = l; l < timeCnt; l++) {
                if (timeCnt - l + 1 < 3) {
                    break;
                }
                while (r + 1 < timeCnt && times.get(r + 1) - times.get(l) <= 60) {
                    r++;
                }
                if (r - l + 1 >= 3) {
                    ansList.add(name);
                    break;
                }
            }
        }
        ansList.sort(Comparator.naturalOrder());
        return ansList;
    }

    // parseInt效率没有chatAt高
    private Integer hhmm2Minutes(String time) {
        String[] arr = time.split(":");
        String h = arr[0], m = arr[1];
        return Integer.parseInt(h) * 60 + Integer.parseInt(m);
    }

    private Integer hhmm2Minutes2(String time) {
        return ((time.charAt(0) - '0') * 10 + time.charAt(1) - '0') * 60 + ((time.charAt(3) - '0') * 10 + time.charAt(4) - '0');
    }
}
