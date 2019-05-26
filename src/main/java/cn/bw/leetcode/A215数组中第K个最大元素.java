package cn.bw.leetcode;

/**
 * @description: 215 数组中第K个最大元素    Top K 问题
 * @auther: bian.wu
 * @date: 2019/4/23 10:04
 */
public class A215数组中第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        k--;
        int lower = 0, higher = nums.length - 1, pivotIndex = 0;
        while (lower <= higher) {

            pivotIndex = partition(nums, lower, higher);
            if (pivotIndex == k) {
                break;
            } else if (pivotIndex < k) {
                lower = pivotIndex + 1;
            } else {
                higher = pivotIndex - 1;
            }
        }
        return nums[k];
    }


    private int partition(int[] nums, int lower, int higher) {
        int pivotIndex = lower + (higher - lower) / 2;

        while (lower < higher) {
            while (lower < pivotIndex && nums[lower] > nums[pivotIndex]) {
                lower++;
            }
            while (higher > pivotIndex && nums[higher] < nums[pivotIndex]) {
                higher--;
            }
            if (lower != higher) {
                swap(nums, lower, higher);
            }

            if (pivotIndex == lower) {
                pivotIndex = higher;
            } else if (pivotIndex == higher) {
                pivotIndex = lower;
            } else {
                lower++;
                higher--;
            }
        }

        return pivotIndex;
    }

    private void swap(int[] d, int i, int j) {
        d[i] = d[i] ^ d[j];
        d[j] = d[i] ^ d[j];
        d[i] = d[i] ^ d[j];
    }

}
