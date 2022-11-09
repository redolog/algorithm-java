package com.algorithm.lookup.bsearch.bsearch;

/**
 * https://leetcode.cn/problems/first-bad-version/
 *
 * @author DragonSong  @date 2022/11/9
 */
public class FirstBadVersion {

    int bad;

    public int firstBadVersion(int n, int bad) {
        this.bad = bad;
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            boolean midBad = isBadVersion(mid);
            if (midBad) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int bad) {
        return this.bad == bad;
    }

}
