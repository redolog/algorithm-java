# 时间复杂度
## 最好、最坏、平均
在分析排序算法的时间复杂度时，要分别给出最好情况、最坏情况、平均情况下的时间复杂度。

除此之外，你还要说出最好、最坏时间复杂度对应的要排序的原始数据是什么样的。

为什么要区分这三种时间复杂度呢？
- 第一，有些排序算法会区分，为了好对比，所以我们最好都做一下区分。
- 第二，对于要排序的数据，有的接近有序，有的完全无序。有序度不同的数据，对于排序的执行时间肯定是有影响的，我们要知道排序算法在不同数据下的性能表现。

平均时间复杂度：加权平均期望时间复杂度。

## 系数、常数 、低阶
时间复杂度反映的是数据规模 n 很大的时候的一个增长趋势，所以它表示的时候会忽略系数、常数、低阶。

但是实际的软件开发中，我们排序的可能是 10 个、100 个、1000 个这样规模很小的数据。
所以，在对同一阶时间复杂度的排序算法性能对比的时候，我们就要把系数、常数、低阶也考虑进来。

## 操作次数
以*基于比较的排序算法的执行过程*为例，会涉及两种操作：
- 一种是元素比较大小
- 另一种是元素交换或移动

所以，如果我们在分析排序算法的执行效率的时候，应该把比较次数和交换（或移动）次数也考虑进去。