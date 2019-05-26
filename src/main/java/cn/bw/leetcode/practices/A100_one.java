package cn.bw.leetcode.practices;

/**
 * @description: 100 相同的树
 * @auther: bian.wu
 * @date: 2019/5/13 23:15
 */
public class A100_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else {
            return true;
        }

    }

}
