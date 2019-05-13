package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/13 22:02
 */
public class A19_one {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode removeNthFromEnd(ListNode head, int n){
          ListNode fast =head, slow = head;

          for(int i=0;i<n;i++){
              fast = fast.next;
          }

          if(fast == null){
              head = head.next;
              return head;
          }

          while (fast.next != null){
              fast = fast.next;
              slow = slow.next;
          }
          slow.next = slow.next.next;
          return head;
  }
}
