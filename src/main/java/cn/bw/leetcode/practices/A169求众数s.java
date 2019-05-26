package cn.bw.leetcode.practices;

/**
 * @description: 169 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @auther: bian.wu
 * @date: 2019/5/23 09:35
 */
public class A169求众数s {

    public int majorityElement(int[] nums) {

        int count = 0;
        int temp = nums[0];
        for (int e : nums) {
            if (e == temp) {
                count++;
                if (count >= (nums.length + 1) / 2) return temp;
            } else {
                count--;
                if (count == 0) {
                    temp = e;
                    count = 1;
                }
            }
        }
        return temp;
    }

}
