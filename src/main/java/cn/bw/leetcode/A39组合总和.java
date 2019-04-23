package cn.bw.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 39 组合总和  回溯
 * @beat  95%
 * @auther: bian.wu
 * @date: 2019/4/23 09:51
 */
public class A39组合总和 {
    List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0 || target <= 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> tmp = new LinkedList<>();
        backTrack(tmp, target, 0, nums);
        return results;
    }

    private void backTrack(List<Integer> tmp, int target, int start, int[] nums) {

        if (target < 0)
            return;
        if (target == 0) {
            results.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            tmp.add(nums[i]);
            backTrack(tmp, target - nums[i], i, nums);
            tmp.remove(tmp.size() - 1);
        }
    }


}
