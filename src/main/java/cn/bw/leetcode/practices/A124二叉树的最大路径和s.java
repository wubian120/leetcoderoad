package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/22 15:37
 */
public class A124二叉树的最大路径和s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int maxSum = Integer.MIN_VALUE;

    /***
     * @beat  95%
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        getMaxSumWithCurNode(root);
        return maxSum;
    }


    int getMaxSumWithCurNode(TreeNode curNode) {
        int lmax = 0, rmax = 0;
        int value = curNode.val;
        // 包含当前节点的最大路径和
        if (curNode.left != null) {
            lmax = getMaxSumWithCurNode(curNode.left);
        }
        if (curNode.right != null) {
            rmax = getMaxSumWithCurNode(curNode.right);
        }

        value = value + (lmax > 0 ? lmax : 0) + (rmax > 0 ? rmax : 0);
        if (value > maxSum)
            maxSum = value;
        // 注意这里的返回值，取左右子树其中一条路径
        return curNode.val + Math.max(lmax > 0 ? lmax : 0, rmax > 0 ? rmax : 0);

    }
}
