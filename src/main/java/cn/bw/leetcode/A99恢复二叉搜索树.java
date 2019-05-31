package cn.bw.leetcode;

/**
 * @description: 99 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * 思路：  利用 中序排序 的 自然序列 的特性 来找到 不满足二叉搜索树 特征的两个值。
 *          最后交换节点值
 * @auther: bian.wu
 * @date: 2019/5/31 10:11
 */
public class A99恢复二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre = null, fst = null, snd = null;

    public void recoverTree(TreeNode root) {

        if(root == null) {
            return;
        }

        pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
//        int temp = fst.val;
//        fst.val = snd.val;
//        snd.val = temp;
        swap(fst,snd);
    }

    private void inorder(TreeNode root){

        if(root == null){
            return;
        }

        inorder(root.left);
        if(fst == null && pre.val > root.val){
            fst = pre;
        }

        if(fst != null && pre.val > root.val){
            // tricky
            snd = root;
        }
        pre = root;
        inorder(root.right);


    }

    private void swap(TreeNode f1,TreeNode f2){
        int tmp = f1.val;
        f1.val = f2.val;
        f2.val = tmp;
    }


}
