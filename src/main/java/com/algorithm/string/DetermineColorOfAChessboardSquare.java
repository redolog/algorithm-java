package com.algorithm.string;

/**
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 *
 * @author songhuilong001  @date 2022/12/8
 */
public class DetermineColorOfAChessboardSquare {

    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '0';
        return row % 2 == col % 2;
    }

    public boolean squareIsWhite2(String coordinates) {
        char col = coordinates.charAt(0);
        int row = coordinates.charAt(1) - '0';
        // 偶数行 白色则为0，否则则为1
        int evenRow = 1;
        switch (col) {
            case 'a':
            case 'c':
            case 'e':
            case 'g':
                evenRow = 0;
                break;
            default:
        }
        return row % 2 == evenRow;
    }
}
