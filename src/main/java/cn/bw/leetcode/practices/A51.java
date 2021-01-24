package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A51 {

    public List<List<String>> solveNQueens(int n){
        List<List<String>> results = new LinkedList<>();
        int[] queens = new int[n];
        backTrack(results,queens,0);
        return results;

    }

    public void backTrack(List<List<String>> res, int[] q, int pos){
        int len = q.length;
        if(pos == len){
            List<String> cur = new ArrayList<>();

            for(int i=0;i<len;i++){
                StringBuilder builder = addPoints(len);
                //
                builder.setCharAt(q[i],'Q');
                cur.add(builder.toString());
            }
            res.add(cur);
            return;
        }
        for(int i=0;i<len;i++){
            q[pos]= i;
            if(isValid(q,pos)){
                backTrack(res,q,pos+1);
            }
        }
    }

    private boolean isValid(int[] q, int pos){
        for(int i=0;i<pos;i++){
            if(q[i]==q[pos]){
                return false;
            }
            if(Math.abs(i-pos)==Math.abs(q[i]-q[pos])){
                return false;
            }
        }
        return true;
    }

    private StringBuilder addPoints(int n){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            builder.append('.');
        }
        return builder;
    }
}
