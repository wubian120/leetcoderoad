package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/10 23:44
 */
public class A102_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        handleLevelOrder(root,results,0);
        return results;
    }

    private void handleLevelOrder(TreeNode root, List<List<Integer>> results, int dept) {
        if (root == null) { return; }

        if (dept >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(dept).add(root.val);

        if (root.left != null) {
            handleLevelOrder(root.left, results, dept + 1);
        }
        if (root.right != null) {
            handleLevelOrder(root.right, results, dept + 1);
        }
    }

}
