package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 145 二叉树的后序遍历
 *             ： 5-19， 非递归依然不是特别熟。 还得练。
 * @auther: bian.wu
 * @date: 2019/5/19 07:38
 */
public class A145_two {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            results.add(0, node.val);

            if (node.left != null) {
                nodeStack.push(node.left);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
            }
        }

        return results;
    }

    public List<Integer> postorderTraversalRecur(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        traversal(root,results);
        return results;
    }

    private void traversal(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        traversal(root.left,result);
        traversal(root.right,result);
        result.add(root.val);

    }
}
