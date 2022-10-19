package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author songhuilong  @date 2022/10/19
 */
public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        // 想吃方形的学生数量
        int squareLikeCnt = 0;
        for (int studentLike : students) {
            squareLikeCnt += studentLike;
        }
        // 想吃圆形的学生数量
        int roundLikeCnt = n - squareLikeCnt;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && roundLikeCnt > 0) {
                // 圆形三明治
                roundLikeCnt--;
                continue;
            }
            if (sandwich == 1 && squareLikeCnt > 0) {
                // 方形三明治
                squareLikeCnt--;
                continue;
            }
            // 通过用例分析，当一种三明治已经吃完之后，已经到了死局：下一个三明治没人可吃
            if (roundLikeCnt == 0 || squareLikeCnt == 0) {
                break;
            }
        }
        return squareLikeCnt + roundLikeCnt;
    }
}
