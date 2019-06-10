package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/10 20:39
 */
public class A51N皇后 {

    public List<List<String>> solveNQueens(int n) {

        if(n<=0){
            return null;
        }
        List<List<String>> results = new LinkedList<>();
        int[] queen = new int[n];
        backTrack(results,queen,0);

        return results;

    }

    private void backTrack(List<List<String>> results, int[] queen, int pos){

        if(pos == queen.length){
            List<String> cur = new LinkedList<>();
            
        }

    }

    private boolean isValid(int[] queen, int pos){
        for(int i=0;i<pos;i++){
            if(queen[i] ==queen[pos]){
                return false;
            }
            if(Math.abs(queen[i]-queen[pos])==Math.abs(i-pos)){
                return false;
            }
        }
        return true;
    }

    private StringBuilder addPoints(int n){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            builder.append(".");
        }
        return builder;
    }


}
