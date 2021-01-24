package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A51N皇后1 {

    public List<List<String>> solveNQueens(int n){
        List<List<String>> results = new ArrayList<>();
        int[] queen = new int[n];
        backTrack(results,queen,0);
        return results;
    }

    private void backTrack(List<List<String>> results, int[] queen, int pos){
        int len = queen.length;
        if(pos == len){
            List<String> result = new LinkedList<>();
            for(int i=0;i<len;i++){
                StringBuilder builder = addPoints(len);
                // 注意 queen[i]
                builder.setCharAt(queen[i],'Q');
                result.add(builder.toString());
            }
            results.add(result);
            //don't forget return
            return;
        }

        for(int i=0;i<len;i++){
            queen[pos] = i;
            if(isValid(queen,pos)){
                backTrack(results,queen,pos+1);
            }
        }
    }

    private boolean isValid(int[] queen, int pos){
        for(int i=0;i<pos;i++){
            if(queen[i] == queen[pos]){
                return false;
            }
            if(Math.abs(i-pos) == Math.abs(queen[i]-queen[pos])){
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
