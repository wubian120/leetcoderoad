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
     * @param candidates
     * @param target
     * @return
     * @beat 98%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //结果集
        List<List<Integer>> res = new ArrayList<>();
        //回溯
        backtrack(res, candidates, target, 0, 0, new ArrayList<Integer>());

        return res;

    }

    /***
     *
     * @param res  结果
     * @param candidates  给定的数组
     * @param target  目标值
     * @param i           数组中元素下标
     * @param tmp_sum      临时 和
     * @param tmp_list     临时的 元素列表
     */
    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, int tmp_sum, ArrayList<Integer> tmp_list) {
        if (tmp_sum == target) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        //从i 开始遍历，边界 < num.len;
        for (int start = i; start < candidates.length; start++) {
            //当前 和  已经大于目标值
            if (tmp_sum + candidates[start] > target) {
                break;
            }
            //当前元素值 == 前值， start > i 表示 已经从下一层跳出。
            // 下一层 值已经 >target. 所以略过，当前相同的值
            if (start > i && candidates[start] == candidates[start - 1]) {
                continue;
            }
            tmp_list.add(candidates[start]);
            //递归
            backtrack(res, candidates, target, start + 1, tmp_sum + candidates[start], tmp_list);

            //删除最后一个 元素
            tmp_list.remove(tmp_list.size() - 1);
        }
    }


    public static void main(String... args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        A40组合总和IIs a = new A40组合总和IIs();
        List<List<Integer>> results = a.combinationSum2(nums, target);

        System.out.println("end");

    }
}
