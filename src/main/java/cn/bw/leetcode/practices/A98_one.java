package cn.bw.leetcode.practices;

/**
 * @description: 98 验证二叉搜索树
 * @auther: bian.wu
 * @date: 2019/5/13 10:34
 */
public class A98_one {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, Long left, Long right) {

        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }
        //tricky part
        return isValid(root.left, left, (long) root.val) && isValid(root.right, (long) root.val, right);
    }
}
