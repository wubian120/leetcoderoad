package cn.bw.leetcode.practices;

/**
 * @description: 101 对称二叉树
 * @auther: bian.wu
 * @date: 2019/5/13 23:10
 */
public class A101_one {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right == null){return true;}
        if(left == null || right== null) return false;

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
