package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/10 20:52
 */
public class A108_two {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null||nums.length<=0){
            return null;
        }
        return buildTree(nums,0,nums.length-1);
    }

    private TreeNode buildTree(int[] data, int start, int end){
        if(start==end){
            return new TreeNode(data[start]);
        }
        if(start > end){
            return null;
        }

        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(data[mid]);

        root.left = buildTree(data,start,mid-1);
        root.right = buildTree(data,mid+1,end);

        return root;
    }

}
