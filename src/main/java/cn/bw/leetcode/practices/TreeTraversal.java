package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *  二叉树的前中后序遍历
 */
public class TreeTraversal {


    public  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> data = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        while (root!= null || !nodeStack.empty()){

            while (root !=null){
                nodeStack.push(root);
                root = root.left;
            }

            if(!nodeStack.empty()){
                root = nodeStack.pop();
                data.add(root.val);
                root = root.right;
            }
        }

        return data;

    }

    public List<Integer> preorderTraversal(TreeNode root){

        List<Integer> data = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()){

            while (cur !=null){
                data.add(cur.val);
                nodeStack.push(cur);
                cur = cur.left;
            }

            if(!nodeStack.isEmpty()){
                cur = nodeStack.pop();
                cur = cur.right;
            }

        }
        return data;

    }

    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()){

            TreeNode cur = nodeStack.pop();
            result.add(0,cur.val);

            if(cur.left != null){
                nodeStack.push(cur.left);
            }

            if(cur.right!=null){
                nodeStack.push(cur.right);
            }

        }

        return result;
    }


}
