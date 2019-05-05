package cn.bw.leetcode;

/**
 * @description:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * @auther: bian.wu
 * @date: 2019/5/5 10:36
 */
public class A19删除链表的倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /***
     * @思路   前后双指针，  前指针先移动 n 个节点，  在和后节点一直移动到尾部，
     *         此时， 后节点距离后面就是 n
     * @beat   95%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head;
        ListNode back = head;

        for (int i=0;i<n;i++){
          front = front.next;
        }
        if(front == null){
            head = head.next;
            return head;
        }

        while (front.next!=null){
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return head;
    }
}
