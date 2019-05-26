package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/14 06:02
 */
public class A103_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        handleZLevel(root, 0, results);
        return results;

    }

    private void handleZLevel(TreeNode root, int level, List<List<Integer>> results) {
        if (root != null) {
            if (level == results.size()) {
                results.add(new LinkedList<>());
            }
            if (level % 2 == 1) {
                results.get(level).add(0, root.val);
            }
            if (level % 2 == 0) {
                results.get(level).add(root.val);
            }

            handleZLevel(root.left, level + 1, results);
            handleZLevel(root.right, level + 1, results);
        }
    }

}
