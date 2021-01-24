package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/9 16:17
 */
public class A102二叉树的层次遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new LinkedList<>();
        levelOrder(root,results,0);
        return results;

    }


    private void levelOrder(TreeNode root, List<List<Integer>> res, int depth){
        if(root == null){
            return;
        }

        if(depth>= res.size()){
            res.add(new LinkedList<>());
        }

        res.get(depth).add(root.val);

        if(root.left != null){
            levelOrder(root.left, res,depth+1);
        }
        if(root.right != null){
            levelOrder(root.right, res, depth+1);
        }

    }




}
