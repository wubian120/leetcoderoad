package cn.bw.leetcode;

/**
 * @description: 4 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * @auther: bian.wu
 * @date: 2019/4/28 21:10
 */
public class A4寻找两个有序数组的中位数 {

    /**
     * @beat  74%
     * @思路  先合并， 排序， 根据总数奇偶 返回 相应中位数。
     * @param nums1   第一个排序数组
     * @param nums2   第二个排序数组
     * @return  中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length;
        int[] data = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            data[i] = nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            data[len1 + i] = nums2[i];
        }

        sort(data);
        int len = len1 + len2;



        return (double)(len & 1) == 1 ? data[len / 2] : (double) (data[len / 2] + data[len / 2 - 1]) / 2.0;

    }

    private void sort(int[] nums) {

        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            int t = nums[i];
            nums[i] = nums[0];
            nums[0] = t;

            heapify(nums, 0, i);
        }

    }

    private void heapify(int[] data, int i, int len) {

        int larger = i, left = i * 2 + 1, right = i * 2 + 2;

        if (left < len && data[left] > data[larger]) {
            larger = left;
        }

        if (right < len && data[right] > data[larger]) {
            larger = right;
        }
        if (larger != i) {
            int t = data[i];
            data[i] = data[larger];
            data[larger] = t;

            heapify(data, larger, len);
        }
    }

    public static void main(String...args){

        int[] nums1 = {1,3};
        int[] nums2 = {2};

        A4寻找两个有序数组的中位数 a = new A4寻找两个有序数组的中位数();
        double median = a.findMedianSortedArrays(nums1,nums2);

        System.out.println(median);
        System.out.println("end");
    }

}
