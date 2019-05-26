package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/23 08:09
 */
public class A124_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {

        if(root==null){
            return 0;
        }
        getMaxPath(root);
        return maxValue;
    }

    int maxValue = Integer.MIN_VALUE;

    private int getMaxPath(TreeNode current) {
        int leftMax = 0, rightMax = 0;
        int value = current.val;

        if (current.left != null) {
            leftMax = getMaxPath(current.left);
        }
        if (current.right != null) {
            rightMax = getMaxPath(current.right);
        }

        value += (leftMax > 0 ? leftMax : 0) + (rightMax > 0 ? rightMax : 0);
        if (value > maxValue) {
            maxValue = value;
        }

        return current.val + Math.max((leftMax > 0 ? leftMax : 0), (rightMax > 0 ? rightMax : 0));
    }

}
