package com.algorithm.dataStructure.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed 的所有元素 互不相同
 * popped.length == pushed.length
 * popped 是 pushed 的一个排列
 * <p>
 * https://leetcode.cn/problems/validate-stack-sequences/
 *
 * @author dragonsong  @date 2022/6/22
 */
public class ValidateStackSequences {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 95.10%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 12.10%
     * 的用户
     * 通过测试用例：
     * 151 / 151
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();

        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                ++j;
            }
        }

        // 其实这里正常 j应该到达 popped.len
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j++]) {
                return false;
            }
        }
        return true;
    }
}
