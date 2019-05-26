package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/23 08:38
 */
public class A257_one {

    public class TreeNode {
        int val;

        TreeNode(int x) {
            val = x;
        }

        TreeNode left;
        TreeNode right;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new LinkedList<>();
        if (root == null) {
            return results;
        }

        dfs(root, results, new String());
        return results;
    }


    private void dfs(TreeNode current, List<String> results, String tmp) {

        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            results.add(tmp + current.val);
        }

        if (current.left != null) {
            dfs(current.left, results, tmp + current.val + "->");
        }

        if (current.right != null) {
            dfs(current.right, results, tmp + current.val + "->");
        }

    }

}
