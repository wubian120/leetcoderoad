package cn.bw.leetcode.practices;



/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/7 23:52
 */
public class A108_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length>0){
            return createTree(nums,0,nums.length-1);
        }else {
            return null;
        }

    }

    private TreeNode createTree(int[] nums, int start, int end){
        if(start>end){
            return null;
        }else if(start==end){
            return new TreeNode(nums[start]);
        }else {
            int mid = start + (end - start)/2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = createTree(nums, start, mid-1);
            root.right = createTree(nums, mid+1, end);
            return root;
        }


    }

}
