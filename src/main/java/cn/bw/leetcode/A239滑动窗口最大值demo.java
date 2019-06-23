package cn.bw.leetcode;

public class A239滑动窗口最大值demo {

    /**
     * @param nums
     * @param k
     * @return
     * @beat 98%
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return new int[]{};
        if (nums.length == 0) return new int[0];
        if (k == 1) return nums;

        int max = Integer.MIN_VALUE;
        int length = nums.length;
//        [1  3  -1] -3  5  3  6  7       3,
// 所以result的长度应该是 length-k+1
        int[] result = new int[length - k + 1];
        //初始化 max 为nums中最大值
        for (int i = 0; i < k; i++) {
            if (max < nums[i]) max = nums[i];
        }

        result[0] = max;
        //注意： 边界为什么是  length-k
        for (int i = 0; i < length - k; i++) {
            //如果第一个就是最大值， 则循环 找 窗口内最大值
            if (max == nums[i]) {
                //清除结果。防止第一个就是最大值，后续无法修改。
                max = Integer.MIN_VALUE;
                //第一个值就是最大值
                for (int j = i + 1; j < i + k + 1; j++) {
                    //赋值最大值
                    if (max < nums[j]) {
                        max = nums[j];
                    }
                }
            } else if (max < nums[i + k]) {
                //最大值在后面两个位子
                max = nums[i + k];
            }
            result[i + 1] = max;
        }
        return result;
    }

    public static void main(String...args){

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        A239滑动窗口最大值demo a = new A239滑动窗口最大值demo();
        int[] result = a.maxSlidingWindow(nums,k);

        System.out.println("end");

    }
}
