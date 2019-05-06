package cn.bw.leetcode.practices;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/6 16:56
 */
public class A146_one {


    public A146_one(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private int capacity;
    private int size = 0;
    Node head = new Node();
    Node tail = new Node();

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> nodeMap = new HashMap<>();

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        //拿出 node, 把node 前后连起来
        Node node = nodeMap.get(key);
        Node nodePrev = node.prev;
        Node nodeNext = node.next;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        //把node放到 链表尾部
        Node tmpTailPrev = tail.prev;
        tmpTailPrev.next = node;
        node.prev = tmpTailPrev;
        node.next = tail;
        tail.prev = node;

        return node.value;

    }

    public void put(int key, int value){
        Node node = nodeMap.get(key);
        //新增
        if(node == null){
            Node aNode = new Node();
            aNode.value = value;
            aNode.key = key;

            if (size>=capacity){
                Node tmpHead = head.next;
                head.next = tmpHead.next;
                tmpHead.next.prev = head;
                nodeMap.remove(tmpHead.key);
            }

            nodeMap.put(key, aNode);
            Node tmpTailPrev = tail.prev;
            tmpTailPrev.next = aNode;
            aNode.prev = tmpTailPrev;
            aNode.next = tail;
            tail.prev = aNode;
            size++;

        }else {
            //node 已存在， 更新
            node.value = value;
            //取出
            Node tmpNodePrev = node.prev;
            Node tmpNodeNext = node.next;

            tmpNodePrev.next = tmpNodeNext;
            tmpNodeNext.prev = tmpNodePrev;
            //放入 队尾

            Node tmpTailPrev = tail.prev;
            tmpTailPrev.next = node;
            tail.prev = node;
            node.prev = tmpTailPrev;
            node.next = tail;

        }
    }


}
