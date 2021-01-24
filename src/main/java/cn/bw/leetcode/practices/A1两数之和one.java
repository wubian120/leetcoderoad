package cn.bw.leetcode.practices;

import java.util.HashMap;
import java.util.Map;

public class A1两数之和one {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberMap = new HashMap<>();
        int index = 0;
        //
        for (int i : nums) {
            numberMap.put(i, index++);
        }
        int len = nums.length;
        //核心：用目标值 - 遍历当前值， 看map中是否包含 差值
        for (int i = 0; i < len; i++) {
            int compli = target - nums[i];
            if (numberMap.containsKey(compli) && numberMap.get(compli) != i) {
                return new int[]{i, numberMap.get(compli)};
            }
        }
        return null;
    }

}
