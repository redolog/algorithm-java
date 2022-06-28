package com.algorithm.dataStructure.skiplist;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimpleSkipList2Test {

    @Test
    public void testSimleSKipList2() {
        SimpleSkipList2<Integer, Integer> skipList = new SimpleSkipList2<>();
        skipList.put(3, 3);
        assertEquals(Integer.valueOf(3), skipList.get(3));
        skipList.put(4, 4);
        skipList.put(2, 2);
        skipList.put(1, 1);
        skipList.put(11, 11);
        skipList.put(12, 12);
        skipList.put(13, 13);
        skipList.put(5, 5);
        assertEquals(Integer.valueOf(4), skipList.get(4));
        assertEquals(Integer.valueOf(2), skipList.get(2));
        assertEquals(Integer.valueOf(1), skipList.get(1));
        assertEquals(Integer.valueOf(11), skipList.get(11));
        assertEquals(Integer.valueOf(12), skipList.get(12));
        assertEquals(Integer.valueOf(13), skipList.get(13));
        assertEquals(Integer.valueOf(5), skipList.get(5));

        int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10000, 1000000);
        for (int i = 0; i < arr.length; i++) {
            skipList.put(i, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            assertEquals(Integer.valueOf(arr[i]), skipList.get(i));
        }
        assertEquals(arr.length, skipList.size);


        System.out.println("===================================");
        System.out.println();
        System.out.println();
        System.out.println();

        //---------------------------------------------------
        //随机无重复元素测试
        SimpleSkipList2<Integer, Integer> noDuplicateSkipList = new SimpleSkipList2<>();

        int[] randomArr = ArrayUtils.createRandomArrayBySize(10000);
        System.out.println("randomArr 生成done");
        Map<Integer, Integer> val2I = new HashMap<>();
        for (int i = 0; i < randomArr.length; i++) {
            val2I.put(randomArr[i], i);
            noDuplicateSkipList.put(randomArr[i], i);
        }
        System.out.println("noDuplicateSkipList put done");
        for (int i = 0; i < randomArr.length; i++) {
            assertEquals(val2I.get(randomArr[i]), noDuplicateSkipList.get(randomArr[i]));
        }

        assertEquals(randomArr.length, noDuplicateSkipList.size);

        noDuplicateSkipList.print();
    }
}