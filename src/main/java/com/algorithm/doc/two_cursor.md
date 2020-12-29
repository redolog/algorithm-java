双指针解题法

也叫 two pointers

### Ref
- [双指针法：总结篇！ 原创 程序员Carl 代码随想录 9月20日](https://mp.weixin.qq.com/s/_p7grwjISfMh0U65uOyCjA)
- [[LeetCode]26. Remove Duplicates from Sorted Array 中文 山景城一姐](https://www.youtube.com/watch?v=nSYALuTFsP4)

### 适用目标数据结构
- 数组
- 链表
- 字符串

### 核心思路
本质上双指针（下标）是一前一后两个下标移动，后面的维护一个不重复的集合，前面的收集新元素进行比较，因为在一轮不重复元素的循环中，可以达到两轮n^2循环的去重效果，因而可降低时间复杂度