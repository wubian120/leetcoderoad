package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
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

}
