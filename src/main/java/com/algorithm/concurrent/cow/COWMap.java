package com.algorithm.concurrent.cow;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用 CopyOnWrite 算法的map集合
 * <p>
 * CopyOnWrite 适用于：
 * 1. 多 worker（进程、线程） 上下文；
 * 2. 读多写少；
 * <p>
 * 核心思想：
 * 延迟写。
 * 将写开销延迟到真正需要数据变化的时刻。
 * 而读取则共享一份资源。
 *
 * @author dragonsong  @date 2022/7/17
 */
public class COWMap<K, V> {

    /**
     * volatile 提供JVM可见性、有序性语义，保证集合有写入后，其他线程可以感知到变化
     */
    private volatile Map<K, V> internalMap;

    public COWMap() {
        internalMap = new HashMap<>();
    }

    public COWMap(Map<K, V> map) {
        internalMap = map;
    }

    public V get(K key) {
        return internalMap.get(key);
    }

    public void put(K key, V val) {
        synchronized (this) {
            // 先拷贝一份副本
            Map<K, V> snapshot = new HashMap<>(internalMap);
            // 副本修改数据
            snapshot.put(key, val);
            // 直接将 internalMap 替换为副本，这里写入保障可见性语义
            internalMap = snapshot;
        }
    }

}
