package cn.bw.leetcode.practices;

/**
 * @description: 99 恢复二叉搜索树
 * @auther: bian.wu
 * @date: 2019/5/13 11:47
 */
public class A99_one {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre = new TreeNode(Integer.MIN_VALUE), fst = null, snd = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root);
        swap(fst, snd);
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) return;

        inorderTraverse(root.left);
        if (fst == null && pre.val > root.val) {
            fst = pre;
        }
        if (fst != null && pre.val > root.val) {
            snd = root;
        }
        pre = root;
        inorderTraverse(root.right);
    }

    private void swap(TreeNode fst, TreeNode snd) {
        if (fst != null && snd != null) {
            int tmp = fst.val;
            fst.val = snd.val;
            snd.val = tmp;
        }
    }

}
