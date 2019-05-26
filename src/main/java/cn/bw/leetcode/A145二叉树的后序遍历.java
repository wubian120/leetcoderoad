package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 145 二叉树的后序遍历
 * @思路
 * @auther: bian.wu
 * @date: 2019/5/24 10:56
 */
public class A145二叉树的后序遍历 {

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //非递归 解法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null){
            return results;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()){
            root = nodeStack.pop();
            //从前往后放 ， 先放root, 然后 root.right, 然后root.left;
            results.add(0,root.val);
            if(root.left!=null){
                //stack 先压left,
                nodeStack.push(root.left);
            }
            if(root.right !=null){
                //stack 后压right，
                nodeStack.push(root.right);
            }
        }
        return results;
    }

    //递归解法
    public List<Integer> postorderTraversal_two(TreeNode root){
        List<Integer> results = new ArrayList<>();

        if(root == null){
            return results;
        }
        postorder(root,results);
        return results;
    }

    private void postorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }


}
