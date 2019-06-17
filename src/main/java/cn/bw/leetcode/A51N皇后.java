package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 51 N皇后
 * <p>
 * https://leetcode-cn.com/problems/n-queens/
 * @auther: bian.wu
 * @date: 2019/6/10 20:39
 */
public class A51N皇后 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new LinkedList<>();
        int[] queen = new int[n];

        backTrack(queen,results,0);

        return results;

    }

    /**
     *
     * @param q
     * @param results
     * @param pos  行
     */
    private  void backTrack(int[] q, List<List<String>> results, int pos) {

        //当前已经到最后一行了 ？
        if(pos == q.length){
            List<String> cur = new ArrayList<>();
            for(int i=0;i<q.length;i++){
                StringBuilder builder = addPoints(q.length);
                builder.setCharAt(q[i],'Q');
                cur.add(builder.toString());
            }
            results.add(cur);
            return;
        }

        for(int i=0;i<q.length;i++){
            q[pos] = i;
            if(isValid(q,pos)){
                backTrack(q,results,pos+1);
            }
        }
    }

    /**
     * 判断是否可以 放
     *
     * @param q
     * @param pos
     * @return
     */
    private boolean isValid(int[] q, int pos) {
        // 注意边界， i<pos
        for (int i = 0; i < pos; i++) {
            //是否在 同一列
            if (q[i] == q[pos]) {
                return false;
            }
            //判断对角线
            if (Math.abs(q[i] - q[pos]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder addPoints(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(".");
        }
        return builder;
    }


}
