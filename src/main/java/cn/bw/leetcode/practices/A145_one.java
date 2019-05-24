package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 145 二叉树的后序遍历
 * @auther: bian.wu
 * @date: 2019/5/18 09:42
 */
public class A145_one {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);
        while (!nodeStack.isEmpty()){

            TreeNode node = nodeStack.pop();
            result.add(0,node.val);
            if(node.left != null){
                nodeStack.push(node.left);
            }

            if(node.right != null){
                nodeStack.push(node.right);
            }

        }


        return result;
    }


    /**
     * 非递归  后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_three(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }

        while (output.size() > 0) {
            TreeNode n = output.pop();
            result.add(n.val);
        }

        return result;
    }





}
