package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * 95 不同的二叉搜素树II
 */
public class A95_one {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n){

        if(n==0){
            return new ArrayList<>();
        }
        return generateTree(1,n);
    }

    private List<TreeNode> generateTree(int start, int end){
        List<TreeNode> results = new LinkedList<TreeNode>();

        if(start > end){
            results.add(null);
            return results;
        }

        if(start == end){
            results.add(new TreeNode(start));
            return results;
        }
        for(int i=start;i<=end;i++){

            List<TreeNode> leftSub = generateTree(start,i-1);
            List<TreeNode> rightSub = generateTree(i+1,end);

            for(TreeNode left:leftSub){
                for(TreeNode right : rightSub){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }

        }

        return results;
    }

}
