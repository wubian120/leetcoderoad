package cn.bw.leetcode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/22 17:08
 */
public class A109有序链表转换为二叉搜索树 {

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

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode start,ListNode end){
        if(start==end){
            return null;
        }
        ListNode fast = start, slow = start;

        while (fast !=end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(start,slow);
        root.right = buildTree(slow.next,end);

        return root;

    }

}
