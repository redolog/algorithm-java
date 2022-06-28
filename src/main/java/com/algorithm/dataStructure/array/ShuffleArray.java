package com.algorithm.dataStructure.array;

public class ShuffleArray {

    /**
     * 原数组
     */
    int[] arr;
    /**
     * 读取下标
     */
    int idx;

    public ShuffleArray(int[] arr) {
        this.arr = arr;
        idx = 0;
    }

    public void shuffle() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int aIdx = randomIdx(n);
            int bIdx = randomIdx(n);
            int a = arr[aIdx];
            arr[aIdx] = arr[bIdx];
            arr[bIdx] = a;
        }
    }

    public int[] random(int n) {
        int[] ans = new int[n];
        int cnt = 0;
        int j = 0;
        for (; cnt < n; idx++) {
            ans[j++] = arr[idx];
            ++cnt;

            if (idx == arr.length - 1 && cnt < n) {
                shuffle();
                idx = 0;
            }
        }
        return ans;
    }

    private int randomIdx(int n) {
        return (int) (Math.random() * n);
    }
}
