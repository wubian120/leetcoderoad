package cn.bw.leetcode;

import cn.bw.leetcode.practices.A94_one;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/12 00:27
 */
public class A104二叉树的最大深度 {

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {

        if(root != null){
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }else {
            return 0;
        }

    }
}
