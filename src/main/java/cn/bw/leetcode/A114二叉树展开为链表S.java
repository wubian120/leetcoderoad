package cn.bw.leetcode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/4 15:12
 */
public class A114二叉树展开为链表S {
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
        //递归 右子树
        TreeNode right = findNext(root.right);
        //递归 左子树
        TreeNode left = findNext(root.left);
        TreeNode cur = left;
        //左子树 不为空
        if(left != null){
            //如果右子 不为空， 继续往右走
            while (cur.right !=null){
                cur = cur.right;
            }

            //把当前节点的右子 连上 root的右子树
            cur.right = right;
            //root右子 为原root的左子
            root.right = left;
            //root 左子置为null;
            root.left = null;
        }
        return root;
    }

}
