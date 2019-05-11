package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 94 二叉树的中序遍历
 * @auther: bian.wu
 * @date: 2019/5/11 23:57
 */
public class A94_one {

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal_one(TreeNode root){
        List<Integer> results = new ArrayList<>();
        inorder(root,results);
        return results;
    }

    private void inorder(TreeNode root,List<Integer> results){
        if(root != null){
            inorder(root.left,results);
            results.add(root.val);
            inorder(root.right,results);
        }
    }

}
