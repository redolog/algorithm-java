package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignLinkedListTest {

    @Test
    public void testDesignLinkedList() {
        DesignLinkedList.MyLinkedList linkedList = new DesignLinkedList.MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        assertEquals(2, linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        assertEquals(3, linkedList.get(1));            //返回3

        // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        // 预期结果：
        //[null,null,null,null,null,null,null,null,4,null,null,null]
        DesignLinkedList.MyLinkedList linkedList2 = new DesignLinkedList.MyLinkedList();
        linkedList2.addAtHead(7);
        linkedList2.addAtHead(2);
        linkedList2.addAtHead(1);
        linkedList2.addAtIndex(3, 0);
        linkedList2.deleteAtIndex(2);
        linkedList2.addAtHead(6);
        linkedList2.addAtTail(4);
        assertEquals(4, linkedList2.get(4));
        linkedList2.addAtHead(4);
        linkedList2.addAtIndex(5, 0);
        linkedList2.addAtHead(6);

        // 输入：
        //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[0],[0]]
        // 预期结果：
        //[null,null,null,null,2,null,2]
        DesignLinkedList.MyLinkedList linkedList3 = new DesignLinkedList.MyLinkedList();
        linkedList3.addAtHead(1);
        linkedList3.addAtTail(3);
        linkedList3.addAtIndex(1, 2);
        assertEquals(2, linkedList3.get(1));
        linkedList3.deleteAtIndex(0);
        assertEquals(2, linkedList3.get(0));

        // ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
        //[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
        // 预期结果：
        //[null,null,null,null,null,null,null,null,null,2,null,null]
        DesignLinkedList.MyLinkedList linkedList4 = new DesignLinkedList.MyLinkedList();
        linkedList4.addAtHead(2);
        linkedList4.deleteAtIndex(1);
        linkedList4.addAtHead(2);
        linkedList4.addAtHead(7);
        linkedList4.addAtHead(3);
        linkedList4.addAtHead(2);
        linkedList4.addAtHead(5);
        linkedList4.addAtTail(5);
        assertEquals(2, linkedList4.get(5));
        linkedList4.deleteAtIndex(6);
        linkedList4.deleteAtIndex(4);
    }

}