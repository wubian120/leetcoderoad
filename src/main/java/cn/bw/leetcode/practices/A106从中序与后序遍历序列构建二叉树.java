package cn.bw.leetcode.practices;

/**
 * @description: 106 从中序与后序遍历序列构建二叉树
 *
 * @题目： https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @ref ：
 * @思路： 后序数组 最后一个是 root,找到root 在中序中的位置， 左右两边子树。
 *          根据 找到的 root 在中序序列里 的位置， 以及左右长度 来确定  进一步找的 后序的范围。
 * @auther: bian.wu
 * @date: 2019/5/29 10:47
 */
public class A106从中序与后序遍历序列构建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || inorder.length<=0|| postorder.length<=0 || postorder.length != inorder.length){
            return null;
        }
        return createTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode createTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if(is>ie || ps>pe){
            return null;
        }
        int cur = search(inorder,postorder[pe]);
        TreeNode root = new TreeNode(postorder[pe]);


        root.left = createTree(inorder,is,cur-1,postorder,ps, ps+cur-1-is);
        root.right = createTree(inorder,cur+1,ie,postorder,ps+cur-is, pe-1);

        return root;
    }

    private int search(int[] inorder, int value){
        int i=0;
        while (inorder[i++] != value){

        }
        return --i;
    }



}
