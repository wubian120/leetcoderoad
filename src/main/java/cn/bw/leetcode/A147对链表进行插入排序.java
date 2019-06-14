package cn.bw.leetcode;

/**
 * 147.对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/submissions/
 */
public class A147对链表进行插入排序 {

    /***
     * @ref : https://www.jianshu.com/p/be3b292c74f4
     * @beat: 90%
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    ListNode myHead;
    public ListNode insertionSortList(ListNode head) {
        ListNode cursor=head;
        myHead=head;
        while(cursor!=null){
            ListNode temp=cursor.next;
            if(temp!=null&&temp.val<cursor.val){  //如果该结点的后一个结点比该节点小
                cutLink(cursor);  //将后一个结点从链表中取出
                insertNode(temp,head);  //将后一个结点插入到适合的位置
            }else{
                cursor=cursor.next;
            }
        }
        return myHead;
    }

    public void cutLink(ListNode one){
        ListNode two=one.next;
        ListNode three=two.next;
        one.next=three;
        two.next=null;
    }

    public void insertNode(ListNode node,ListNode head){
        ListNode temp=myHead;
        ListNode pre=null;
        while(node.val>temp.val){
            pre=temp;
            temp=temp.next;
        }
        node.next=temp;
        if(pre!=null){
            pre.next=node;
        }else{
            myHead=node;
        }
    }


}
