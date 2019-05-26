package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 107 二叉树的层次遍历II
 * @auther: bian.wu
 * @date: 2019/5/10 23:53
 */
public class A107_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        handle(root, 0);
        return results;
    }

    private void handle(TreeNode root, int dept) {

        if (root == null) {
            return;
        }

        if (dept == results.size()) {
            results.add(0,new ArrayList<>());
        }

        if (root.left != null) {
            handle(root.left, dept + 1);
        }
        if (root.right != null) {
            handle(root.right, dept + 1);
        }
        results.get(results.size() - 1 - dept).add(root.val);
    }

}
