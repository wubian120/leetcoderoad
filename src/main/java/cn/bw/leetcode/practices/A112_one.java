package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/12 23:53
 */
public class A112_one {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == sum) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
