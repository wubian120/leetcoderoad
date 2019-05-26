package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/15 23:09
 */

public class A105_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,inorder.length-1);
    }

    private int search(int[] inorder, int start, int end, int data) {
        for (int i = end; i >= start; i--) {
            if (inorder[i] == data) {
                return i;
            }

        }
        return -1;
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= inorder.length) {
            return null;
        }

        int j = search(inorder, left, right, preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = build(preorder, inorder, left, j - 1);
        node.right = build(preorder, inorder, j + 1, right);

        return node;

    }

}
