package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/sorted-merge-lcci/
 *
 * @author DragonSong  @date 2022/10/24
 */
public class SortedMergeLcci {

    public int[] merge(int[] arrA, int m, int[] arrB, int n) {
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (i >= 0) {
            if (a < 0) {
                arrA[i] = arrB[b];
                b--;
                i--;
                continue;
            }
            if (b < 0) {
                arrA[i] = arrA[a];
                a--;
                i--;
                continue;
            }
            if (arrB[b] >= arrA[a]) {
                arrA[i] = arrB[b];
                b--;
                i--;
                continue;
            }
            if (arrB[b] < arrA[a]) {
                arrA[i] = arrA[a];
                a--;
                i--;
            }
        }
        return arrA;
    }

    public int[] merge2(int[] arrA, int m, int[] arrB, int n) {
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (i >= 0) {
            if (a < 0) {
                arrA[i] = arrB[b];
                b--;
            } else if (b < 0) {
                arrA[i] = arrA[a];
                a--;
            } else if (arrB[b] >= arrA[a]) {
                arrA[i] = arrB[b];
                b--;
            } else if (arrB[b] < arrA[a]) {
                arrA[i] = arrA[a];
                a--;
            }
            i--;
        }
        return arrA;
    }

    public int[] merge3(int[] arrA, int m, int[] arrB, int n) {
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (i >= 0) {
            int num = 0;
            if (a < 0) {
                num = arrB[b--];
            } else if (b < 0) {
                num = arrA[a--];
            } else if (arrB[b] >= arrA[a]) {
                num = arrB[b--];
            } else if (arrB[b] < arrA[a]) {
                num = arrA[a--];
            }
            arrA[i--] = num;
        }
        return arrA;
    }

    /**
     * 个人觉得这个写法最优，最易懂、简洁
     */
    public int[] merge4(int[] arrA, int m, int[] arrB, int n) {
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (i >= 0) {
            if (a < 0) {
                arrA[i--] = arrB[b--];
            } else if (b < 0) {
                arrA[i--] = arrA[a--];
            } else if (arrB[b] >= arrA[a]) {
                arrA[i--] = arrB[b--];
            } else if (arrB[b] < arrA[a]) {
                arrA[i--] = arrA[a--];
            }
        }
        return arrA;
    }

    public int[] merge5(int[] arrA, int m, int[] arrB, int n) {
        int a = m - 1, b = n - 1;
        while (a >= 0 && b >= 0) {
            if (arrB[b] >= arrA[a]) {
                arrA[a + b + 1] = arrB[b--];
            } else {
                arrA[a + b + 1] = arrA[a--];
            }
        }
        // arrB没走完
        while (b >= 0) {
            arrA[b] = arrB[b--];
        }
        return arrA;
    }

}
