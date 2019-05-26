package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    /***
     * 中序遍历， 递归
     * @param root
     * @return
     */
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

    /***
     * 中序遍历 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_two(TreeNode root){
        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        while (root != null || !nodeStack.isEmpty()){
            while (root != null){
                nodeStack.push(root);
                root = root.left;
            }

            if(!nodeStack.isEmpty()){
                root = nodeStack.pop();
                results.add(root.val);
                root = root.right;
            }
        }
        return results;
    }





}
