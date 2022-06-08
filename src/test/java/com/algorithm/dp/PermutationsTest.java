package com.algorithm.dp;

import com.algorithm.util.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsTest {

    Permutations service;

    @Before
    public void init() {
        service = new Permutations();
    }

    @Test
    public void permuteTest() {
        int[] arr123 = {1, 2, 3};
        List<List<Integer>> ans123 = service.permute(arr123);

        List<List<Integer>> offcialAns123 = permute(arr123);

        Assert.assertTrue(CollectionUtils.equals(ans123,offcialAns123));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}