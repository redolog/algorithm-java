# 特里树

也叫单词树、前缀树。

> Trie 树，也叫“字典树”。顾名思义，它是一个树形结构。它是一种专门处理字符串匹配的数据结构，用来解决在一组字符串集合中快速查找某个字符串的问题。
>
> Trie 树的本质，就是利用字符串之间的公共前缀，将重复的前缀合并在一起。
>

## 复杂度

时间复杂度： 查找、匹配单词复杂度只跟word长度有关，查一次最多遍历`len(word)`个节点。因此时间复杂度`O(len(word))`。

## 使用场景

### 注意事项

1. 字符串中包含的字符集不能太大。
2. 要求字符串的前缀重合比较多，不然空间消耗会变大很多。
3. 跳转结构，对CPU缓存不友好。

### 适用情况

查找前缀匹配的字符串（非精确搜索），如搜索提示。