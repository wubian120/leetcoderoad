package cn.bw.leetcode;

/**
 * @description: 2 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @auther: bian.wu
 * @date: 2019/5/5 10:46
 */
public class A2两数相加 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ahead = new ListNode(0);
        ListNode current = ahead;
        int sum = 0;
        while (l1 != null || l2 != null) {

            int v1 = (l1 == null ? 0 : l1.val);
            int v2 = (l2 == null ? 0 : l2.val);

            current.next = new ListNode((sum+v1+v2) % 10);
            current = current.next;
            sum = (v1+v2+sum) / 10;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            if(sum>0){
                current.next = new ListNode(sum);

            }
        }
        return ahead.next;

    }

}
