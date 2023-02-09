package com.algorithm.dataStructure.array.app;

import java.util.*;

/**
 * https://leetcode.cn/problems/design-authentication-manager/
 *
 * @author songhuilong001  @date 2023/2/9
 */
public class AuthenticationManager {

    private int timeToLive;

    private Map<String, Integer> tokenId2InsertTime;

    private List<String> tokenIdInOrder;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenId2InsertTime = new HashMap<>();
        this.tokenIdInOrder = new ArrayList<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenId2InsertTime.put(tokenId, currentTime);
        tokenIdInOrder.add(tokenId);
    }

    public void expire(String tokenId) {
        Iterator<String> iterator = tokenIdInOrder.iterator();
        while (iterator.hasNext()) {
            String id = iterator.next();
            tokenId2InsertTime.remove(id);
            iterator.remove();
            if (id.equals(tokenId)) {
                break;
            }
        }
    }

    public void renew(String tokenId, int currentTime) {
        Integer insertTime = tokenId2InsertTime.get(tokenId);
        if (insertTime != null) {
            if (insertTime + timeToLive > currentTime) {
                // 依旧存活，续期
                tokenId2InsertTime.put(tokenId, currentTime);
            } else {
                // 过期，删除entry，同时将时间序列递增的前序entry都删除
                expire(tokenId);
            }
        }
        // 不存在，不管了
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        Iterator<Map.Entry<String, Integer>> iterator = tokenId2InsertTime.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() + timeToLive > currentTime) {
                cnt++;
            } else {
                iterator.remove();
            }
        }
        return cnt;
    }
}
