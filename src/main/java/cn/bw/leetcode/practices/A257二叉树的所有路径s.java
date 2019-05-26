package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/22 15:25
 */
public class A257二叉树的所有路径s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * @param root
     * @return
     * @beat 70%
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        strAdd(list, root, "");
        return list;
    }

    private void strAdd(List<String> list, TreeNode root, String str) {//list.add
        if (root == null) {
            return;
        }

        //返回String类型的root.val的值
        str += String.valueOf(root.val);

        //是void类型，不需要写return。
        if (root.left != null) {
            strAdd(list, root.left, str + "->");
        }
        if (root.right != null) {
            strAdd(list, root.right, str + "->");
        }
        if (root.left == null && root.right == null) {
            list.add(str);
        }
    }


    /**
     * @beat  98%
     * @param root
     * @return
     */
    public List<String> binaryTreePaths_two(TreeNode root) {
        List<String> list = new LinkedList<String>();
        helper(root, list, new String());
        return list;
    }

    public void helper(TreeNode root, List<String> list, String s) {
        //root为空，易知，只有一种情况，那就是题目所给是空树。
        if (root == null) {
            return;
        }
        //没有左右孩子,当前节点是叶子节点,所以形成一条路径=s(根节点到父节点路径)+当前节点
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
            return;
        }
        if (root.left != null) {
            //存在左孩子,所以到当前节点路径=s(根节点到父节点路径)+当前节点值+"->"
            helper(root.left, list, s + root.val + "->");
        }
        if (root.right != null) {
            //同理
            helper(root.right, list, s + root.val + "->");
        }
    }


}
