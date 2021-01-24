package cn.bw.leetcode.practices;

public class A105_two {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,inorder.length-1);
    }

    int index = 0;

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
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, left, j - 1);
        root.right = build(preorder, inorder, j + 1, right);
        return root;
    }

}
