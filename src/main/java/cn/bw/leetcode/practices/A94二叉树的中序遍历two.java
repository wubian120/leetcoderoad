package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/19 09:13
 */
public class A94二叉树的中序遍历two {
    public  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        while (root!=null || !nodeStack.isEmpty()) {

            while (root!=null){
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
