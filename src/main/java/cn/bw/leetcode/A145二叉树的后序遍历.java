package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);
        while (!nodeStack.isEmpty()){

            root = nodeStack.pop();
            results.add(0,root.val);
            if(root.left!=null){
                nodeStack.push(root.left);
            }
            if(root.right !=null){
                nodeStack.push(root.right);
            }

        }
        return results;

    }
}
