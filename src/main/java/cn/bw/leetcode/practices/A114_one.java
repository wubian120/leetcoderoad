package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/15 11:22
 */
public class A114_one {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        findNext(root);
    }

    private TreeNode findNext(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = findNext(root.right);
        TreeNode left = findNext(root.left);
        TreeNode current = left;

        if (left != null) {
            while (current.right != null) {
                current = current.right;
            }
            current.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }


}
