package com.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author DragonSong  @date 2020/12/17
 * @link {https://leetcode-cn.com/problems/pascals-triangle/}
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        return traverse(numRows);
    }

    private List<List<Integer>> traverse(int numRows) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return retList;
        }
        List<Integer> row1 = new ArrayList<Integer>() {
            {
                add(1);
            }
        };
        retList.add(row1);
        if (numRows == 1) {
            return retList;
        }
        List<Integer> row2 = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
            }
        };
        retList.add(row2);
        if (numRows == 2) {
            return retList;
        }
        // 从第三行开始迭代
        for (int row = 2; row < numRows; row++) {
            List<Integer> thisRow = new ArrayList<Integer>();
            for (int column = 0; column <= row; column++) {
                // 首列末列均为1
                if (column == 0 || column == row) {
                    thisRow.add(1);
                } else {
                    List<Integer> prevRow = retList.get(row - 1);
                    thisRow.add(prevRow.get(column - 1) + prevRow.get(column));
                }
            }
            retList.add(thisRow);
        }
        return retList;
    }
}
