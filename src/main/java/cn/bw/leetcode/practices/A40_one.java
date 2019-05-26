package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/24 16:27
 */
public class A40_one {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), results);
        return results;
    }


    private void backtrack(int[] candidates, int target, int index, int currentSum, List<Integer> currentResult, List<List<Integer>> results) {

        if(currentSum == target){
            results.add(new ArrayList<>(currentResult));
            return;
        }
        int len = candidates.length;
        for(int current = index; current<len;current++){

            if(currentSum + candidates[current] > target){
                break;
            }
            if(current>index && candidates[current] == candidates[current-1]){
                continue;
            }

            currentResult.add(candidates[current]);

            backtrack(candidates, target, current+1, currentSum+candidates[current], currentResult, results);

            //到这步 意味着， 已经从下层 backtrack跳出来了。即 已经大于target。
            currentResult.remove(currentResult.size()-1);
        }
    }
}
