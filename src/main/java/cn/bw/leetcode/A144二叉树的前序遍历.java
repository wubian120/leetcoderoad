package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/24 10:29
 */
public class A144二叉树的前序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        while (root!=null || !nodeStack.isEmpty()){

            while (root!=null){
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
}
