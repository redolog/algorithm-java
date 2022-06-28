package com.algorithm.dataStructure.skiplist;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimpleSkipListTest {

    @Test
    public void testSimpleSkipList() {
        SimpleSkipList skipList = new SimpleSkipList();
//        skipList.put(3,3);
//        assertEquals(3,skipList.get(3).val);
//        skipList.put(4,4);
//        assertEquals(4,skipList.get(4).val);
//        skipList.put(2,2);
//        assertEquals(2,skipList.get(2).val);
//        skipList.put(1,1);
//        assertEquals(1,skipList.get(1).val);
//        skipList.put(11,11);
//        assertEquals(11,skipList.get(11).val);
//        skipList.put(12,12);
//        assertEquals(12,skipList.get(12).val);
//        skipList.put(13,13);
//        assertEquals(13,skipList.get(13).val);
//        skipList.put(5,5);
//        assertEquals(5,skipList.get(5).val);
//        skipList.print();

        int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10000, 1000000);
        for (int i = 0; i < arr.length; i++) {
            skipList.put(i, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], skipList.get(i).val);
        }
        assertEquals(arr.length, skipList.size);

        System.out.println("===================================");
        System.out.println();
        System.out.println();
        System.out.println();

        //---------------------------------------------------
        //随机无重复元素测试
        SimpleSkipList noDuplicateSkipList = new SimpleSkipList();

        int[] randomArr = ArrayUtils.createRandomArrayBySize(10000);
        System.out.println("randomArr 生成done");
        Map<Integer, Integer> val2I = new HashMap<>();
        for (int i = 0; i < randomArr.length; i++) {
            val2I.put(randomArr[i], i);
            noDuplicateSkipList.put(randomArr[i], i);
        }
        System.out.println("noDuplicateSkipList put done");
        for (int i = 0; i < randomArr.length; i++) {
            assertEquals((int) val2I.get(randomArr[i]), noDuplicateSkipList.get(randomArr[i]).val);
        }

        assertEquals(randomArr.length, noDuplicateSkipList.size);

        noDuplicateSkipList.print();

    }
}