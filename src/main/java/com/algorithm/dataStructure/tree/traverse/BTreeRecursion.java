package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

public class BTreeRecursion {

    /*
     * 递归序：
     * 以下方recurse方法为例，我们传入一棵二叉树， 1 2 3 4 5 6
     * recurse被调用执行后的过程：
     * 1. node1首次经过，非空，传入node1.left==node2
     * 2. node2首次经过，非空，传入node2.left==node4
     * 3. node4首次经过，非空，传入node4.left==null
     * 4. node4.left==null，直接返回
     * 5. node4.right 传入，node4.right==null，直接返回
     * 7. node2第二次经过，node2.right 传入，node2.right==node5，非空
     * 8. node5首次经过，非空，传入node5.left
     * 9. node5.left==null，空直接返回
     * 10. node5.right==null，空直接返回
     * 11. node2第三次经过
     * 12. node1第二次经过，传入node1.right==node3
     * 13. node3首次经过，非空，传入node3.left
     * 14. node6首次经过，非空，传入node6.left
     * 15. node6第二次经过，node6.left空直接返回
     * 16. node6第三次经过，node6.right空直接返回
     * 17. node3第二次经过，传入node3.right
     * 18. node3.right空，直接返回，node3第三次经过
     * 19. node1第三次经过
     *
     * 二叉树的前序、中序、后序遍历区别：
     * 打印本节点分别是第一次经过即打印、第二次经过打印，第三次经过打印
     *
     * 可以发现，上述过程，我们可以通过栈来模拟：
     * 1. 拿到节点node，先压栈；
     * 2. 出栈获取当前节点，如有右子，则压栈，如有左子，则压栈；
     * 3. 持续从栈中出栈、压栈，重复1.2.；
     */

    public void recurse(TreeNode node) {
        if (node == null) {
            // 当前node经过，判断是否为空，空直接返回
            return;
        }
        recurse(node.left);
        recurse(node.right);
    }
}
