package cn.bw.leetcode;

/**
 * @description: 98.验证二叉搜索树
 * @auther: bian.wu
 * @date: 2019/5/24 14:47
 */
public class A98验证二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right){
        if(root==null){
            return true;
        }
        if((long)root.val <= left || (long)root.val >= right){
            return false;
        }

        // tricky part
        return isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);

    }

}
