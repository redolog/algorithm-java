# 最小生成树

针对带权无向图。

设有 v 个节点的一个图，内部有 v-1 条边组成的一张子图，并且 v-1 边权重和最小，我们称这个子树为最小生成树。

## 应用

- 电缆布线
  - 保证每个节点间均可连通、供电
  - 费用最低
- 网络设计
- 电路设计

## 切分定理

Cut Property 把图中的节点分为两部分，称为一个切分（Cut）。

给定任意切分，横切边中权值最小的边必然属于最小生成树。

### 横切边

如果一条边的两个端点，属于一个切分不同的两边，这个边就叫做横切边（Crossing Edge）。

![](minimum-span-tree/cut_property.png)


