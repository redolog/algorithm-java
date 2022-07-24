package com.algorithm.dataStructure.array.diff;

/**
 * 差分数组模板
 * 与前缀和类似，是一种对数组预处理的技巧
 * <p>
 * diff[i]=num[i]-num[i-1] ，即差分数组 diff中存储每一项与前一项之差
 * <p>
 * 适用于数组范围同一增减操作的情况
 *
 * @author dragonsong  @date 2022/7/24
 */
public class DiffArray {
    /**
     * 差分数组
     */
    int[] diff;

    public DiffArray(int n) {
        assert n > 0;
        diff = new int[n];
    }

    public DiffArray(int[] nums) {
        assert nums != null;

        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 对 [from,to] 范围数据 +val 操作
     * 相比直接操作原数组，这里操作为 O(1) 复杂度
     *
     * @param from 左闭区间
     * @param to   右闭区间
     * @param val  操作值
     */
    public void rangeOp(int from, int to, int val) {
        // [from,end] 均做了+val操作
        diff[from] += val;
        if (to + 1 < diff.length) {
            // 如果 to+1 未越界，则对 [to+1,end] 减去val，做抵消
            diff[to + 1] -= val;
        }
    }

    /**
     * 根据差分数组还原原始数组
     * 部分题型可以使用diff[]，可以考虑不创建新的数组返回
     */
    public int[] diff2Origin() {
        int[] originArr = new int[diff.length];
        originArr[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            originArr[i] = originArr[i - 1] + diff[i];
        }
        return originArr;
    }

}
