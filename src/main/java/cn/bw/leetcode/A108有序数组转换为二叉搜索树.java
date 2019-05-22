package cn.bw.leetcode;

/**
 * @description: 108 有序数组转换为二叉搜索树
 * @auther: bian.wu
 * @date: 2019/5/22 16:55
 */
public class A108有序数组转换为二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null) {
            return null;
        }
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] data, int start, int end) {
        if (start == end) {
            return new TreeNode(data[start]);
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(data[mid]);
        root.left = createTree(data, start, mid - 1);
        root.right = createTree(data, mid + 1, end);

        return root;
    }
}
