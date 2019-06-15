package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A40组合总和II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<>();

        backtrack(results,candidates,target,0,0,new ArrayList<>());
        return results;

    }


    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, int tempSum, List<Integer> tmpRes) {
        if (tempSum == target) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int start = i; start < candidates.length; start++) {

            if(tempSum + candidates[start]>target){
                break;
            }

            if(start>i && candidates[start] == candidates[start-1]){
                continue;
            }

            tmpRes.add(candidates[start]);
            backtrack(res,candidates,target,start+1,tempSum+candidates[start], tmpRes);

            tmpRes.remove(tmpRes.size()-1);
        }
    }
}
