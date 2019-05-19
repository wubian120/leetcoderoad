package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 144
 * @auther: bian.wu
 * @date: 2019/5/19 07:56
 */
public class A144_one {
    public  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> results = new LinkedList<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        while (root!=null || !nodeStack.isEmpty()){

            while (root!= null){
                results.add(root.val);
                nodeStack.push(root);
                root = root.left;
            }
            if(!nodeStack.isEmpty()){
                root = nodeStack.pop();
                root = root.right;
            }
        }
        return results;


    }

    List<Integer> results = new LinkedList<>();
    public List<Integer> preorderTraversalRecur(TreeNode root){

        if(root == null){
            return results;
        }
        results.add(root.val);
        preorderTraversalRecur(root.left);
        preorderTraversalRecur(root.right);
        return results;
    }







}
