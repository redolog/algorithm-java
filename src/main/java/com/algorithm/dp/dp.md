动态规划

### Ref
- [What is Dynamic Programming?
](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2G1pAq0OO0#:~:text=Dynamic%20Programming%20(DP)%20is%20an,optimal%20solution%20to%20its%20subproblems.)
- [清华学霸总结的动态规划4步曲，仅这篇动归够了](https://mp.weixin.qq.com/s/0wqHKHBKPNlLQhY20gVQGQ)
- [原来大神都是这样学动态规划的...](https://mp.weixin.qq.com/s/uthpSrJIJQEpiU6g6z5FBg)

### 动态规划的特征
- 子问题重叠
以斐波那契数列求解为例，fib(3)可分解为fib(2)+fib(1)，其中fib(2)可分解为fib(0)+fib(1)。这个过程中的fib(1)会重复求解。
- 最优子结构属性
大问题可以化解为子问题，子问题有其最优解。

### 动态规划结题方法
- 自顶向下的记忆（缓存）
大问题拆为小问题，小问题可继续拆分，每个问题的求解存在重复计算，可由顶部fib(3)开始，将重复计算结果缓存起来。
- 自底向上制表
制表法与记忆法方向相反，从下而上避免递归，目标是填充想要的n维表。表填完了，题目得解。做法：从最小的问题开始计算。

> 抄：
 1、确定问题状态
      - 提炼最后一步
      - 子问题转化
 2、转移方程，把问题方程化
 3、按照实际逻辑设置初始条件和边界情况
 4、确定计算顺序并求解