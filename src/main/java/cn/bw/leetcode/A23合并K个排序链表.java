package cn.bw.leetcode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/24 15:21
 */
public class A23合并K个排序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length>0){
            return mergeSort(lists,0,lists.length-1);
        }else {
            return null;
        }

    }


    private ListNode mergeSort(ListNode[] lists, int low, int high) {
        if(low<high){

            int mid = low + (high-low)/2;
            ListNode leftList = mergeSort(lists,low,mid);
            ListNode rightList = mergeSort(lists,mid+1,high);
            return mergeTwoList(leftList,rightList);

        }else if(low==high){
            return lists[low];
        }else {
            return null;
        }
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode ahead = new ListNode(0);
        ListNode current = ahead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = new ListNode(l1.val);
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = new ListNode(l2.val);
            l2 = l2.next;
            current = current.next;
        }
        return ahead.next;
    }
}
