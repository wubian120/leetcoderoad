package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/13 23:25
 */
public class A102_two {

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

    public void handleLevelOrder(TreeNode root, List<List<Integer>> results, int dept) {
        if (root == null) {
            return;
        }
        if (dept > results.size()) {
            results.add(new LinkedList<>());
        }
        results.get(dept).add(root.val);

        handleLevelOrder(root.left, results, dept + 1);

        handleLevelOrder(root.right, results, dept + 1);

    }
}
