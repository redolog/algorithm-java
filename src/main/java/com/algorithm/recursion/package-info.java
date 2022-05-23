package com.algorithm.recursion;
/**
 * 分治是一种解决问题的处理思想，递归是一种编程技巧
 * <p>
 * 递推公式：
 * recurse(p…r) = merge(recurse(p…q), recurse(q+1…r))
 * <p>
 * 终止条件：
 * p >= r 不用再继续分解
 */