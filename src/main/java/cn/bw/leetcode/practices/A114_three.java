package cn.bw.leetcode.practices;

public class A114_three {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root){
        findNext(root);
    }

    private TreeNode findNext(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode right = findNext(root.right);
        TreeNode left = findNext(root.left);
        TreeNode current = left;

        if(left != null){

            while (current.right !=null){
                current = current.right;
            }

            current.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }

    public static void main(String...args){

        A114_three a = new A114_three();

    }

}
