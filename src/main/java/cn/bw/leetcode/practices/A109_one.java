package cn.bw.leetcode.practices;

/**
 * @description: 109 有序链表 转换为 二叉搜索树
 * @auther: bian.wu
 * @date: 2019/5/14 06:16
 */
public class A109_one {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;

        return createTree(head,null);
    }

    private TreeNode createTree(ListNode head, ListNode tail){
        if(head == tail) return null;

        ListNode fast = head, slow = head;
        while (fast!=tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createTree(head,slow);
        root.right = createTree(slow.next,tail);
        return root;
    }


}
