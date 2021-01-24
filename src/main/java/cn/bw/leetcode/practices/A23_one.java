package cn.bw.leetcode.practices;

import cn.bw.leetcode.A23合并K个排序链表;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/1 12:30
 */
public class A23_one {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if(len>0){
            return mergeSort(lists,0,len-1);
        }else {
            return null;
        }
    }

    private ListNode mergeSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            ListNode leftList = mergeSort(lists, low, mid);
            ListNode rightList = mergeSort(lists, mid + 1, high);

            return mergeTwoLists(leftList, rightList);

        } else if (low == high) {
            return lists[low];
        } else {
            return null;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode beforeHead = new ListNode(0);
        ListNode current = beforeHead;

        while (l1 != null && l2 != null) {

            if(l1.val<l2.val){
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            }else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }

        }

        while (l1 !=null){
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 !=null){
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }
        return beforeHead.next;
    }

}
