package cn.bw.leetcode.practices;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/28 10:47
 */
public class A95_two {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return Collections.emptyList();
        }
        return build(1, n);
    }


    private List<TreeNode> build(int start, int end) {
        List<TreeNode> nodeList = new LinkedList<>();
        if (start > end) {
            nodeList.add(null);
            return nodeList;
        }
        if (start == end) {
            TreeNode cur = new TreeNode(start);
            nodeList.add(cur);
            return nodeList;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftSub = build(start, i - 1);
            List<TreeNode> rightSub = build(i + 1, end);

            for (TreeNode left : leftSub) {
                for (TreeNode right : rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    nodeList.add(root);
                }
            }

        }
        return nodeList;

    }

}
