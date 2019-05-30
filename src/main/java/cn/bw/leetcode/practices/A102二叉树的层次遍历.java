package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/30 20:26
 */
public class A102二叉树的层次遍历 {

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

        level(root,0,results);
        return results;
    }

    private void level(TreeNode root, int dept, List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        // 注意 >=
        if (dept >= results.size()) {
            results.add(new LinkedList<>());
        }
        results.get(dept).add(root.val);

        level(root.left, dept + 1, results);
        level(root.right, dept + 1, results);

    }

}
