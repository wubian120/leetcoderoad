package cn.bw.leetcode;

/**
 * @description: 169 求众数
 * @题目： https://leetcode-cn.com/problems/majority-element/
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
 * @思路： 遍历数据 nums，每个数 有个计数count，从第一个数res 开始统计 count，
 *        如果count == 0 换一个数，  如果count > len/2 则返回。
 *
 * @auther: bian.wu
 * @date: 2019/5/24 10:40
 */
public class A169求众数 {

    public int majorityElement(int[] nums) {

        int count = 0, res = nums[0], maxLen = nums.length / 2;
        for (int number : nums) {
            if (number == res) {
                count++;
                if (count > maxLen) {
                    return res;
                }
            } else {
                count--;
                if (count == 0) {
                    res = number;
                    count=1;
                }
            }
        }
        return res;
    }

}
