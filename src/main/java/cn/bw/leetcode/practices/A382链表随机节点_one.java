package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/21 18:13
 */
public class A382链表随机节点_one {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    Random ran;
    List<ListNode> nodeList;

    public A382链表随机节点_one(ListNode head) {
        nodeList = new ArrayList<>();
        ran = new Random();

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
    }

    public int getRandom() {
        ListNode node = nodeList.get(ran.nextInt(nodeList.size()));
        return node.val;
    }

}
