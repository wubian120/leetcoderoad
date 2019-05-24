package cn.bw.leetcode.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 组合总和II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @auther: bian.wu
 * @date: 2019/5/24 09:34
 */
public class A40组合总和IIs {

    /**
     * @beat 98%
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, 0, 0, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, int tmp_sum, ArrayList<Integer> tmp_list) {
        if (tmp_sum == target) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (tmp_sum + candidates[start] > target) break;
            if (start > i && candidates[start] == candidates[start - 1]) continue;
            tmp_list.add(candidates[start]);
            backtrack(res, candidates, target, start + 1, tmp_sum + candidates[start], tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
