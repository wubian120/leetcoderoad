package cn.bw.leetcode.practices;

public class A98_two {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, Long left, Long right){
        if(root == null){
            return true;
        }
        if((long)root.val<=left || (long)root.val >= right){
            return false;
        }

        return isValidBST(root.left, left, (long)root.val) && isValidBST(root.right, (long) root.val, right);

    }
}
