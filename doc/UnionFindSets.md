# 并查集

Union Find Sets

> 百度百科：
> 并查集，
>
> 在一些有N个元素的集合应用问题中，
> 我们通常是在开始时让每个元素构成一个单元素的集合，
> 然后按一定顺序将属于同一组的元素所在的集合合并，
> 其间要反复查找一个元素在哪个集合中。
>
> 这一类问题近几年来反复出现在信息学的国际国内赛题中。其特点是看似并不复杂，但数据量极大，若用正常的数据结构来描述的话，往往在空间上过大，计算机无法承受；即使在空间上勉强通过，运行的时间复杂度也极高，根本就不可能在比赛规定的运行时间（1～3秒）内计算出试题需要的结果，只能用并查集来描述。 并查集是一种树型的数据结构，用于处理一些不相交集合（disjoint sets）的合并及查询问题。常常在使用中以森林来表示。
>
> Wiki
>
> In computer science, a disjoint-set data structure, also called a union–find data structure or merge–find set, is a data structure that stores a collection of disjoint (non-overlapping) sets. Equivalently, it stores a partition of a set into disjoint subsets. It provides operations for adding new sets, merging sets (replacing them by their union), and finding a representative member of a set. The last operation makes it possible to find out efficiently if any two elements are in the same or different sets.
>

## 适于解决的问题

### 连接问题

相比路径问题，连接问题只需判断点与点之间是否相连，而路径则需求出点与点之间的详情，因此连接问题回答更少信息，从算法设计上可以有很多省略、优化的点。

- 网络中节点间的连接状态

### 数学集合

- 可以用于实现数学中的集合类

## 实现

最基本的`UnionFind`结构，实现两个接口：

- union(p,q)
  连接p点与q点
- find(p)
  查找p点

回答的问题是：

- isConnected(p,q)