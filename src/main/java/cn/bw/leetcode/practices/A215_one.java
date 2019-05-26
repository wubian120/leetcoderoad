package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/23 09:14
 */
public class A215_one {

    public int findKthLargest(int[] nums, int k) {
        k--;
        int lower = 0, higher = nums.length - 1, pivot = 0;
        while (lower <= higher) {
            pivot = part(nums, lower, higher);
            if (pivot == k) {
                break;
            } else if (pivot < k) {
                lower = pivot + 1;
            } else if (pivot > k) {
                higher = pivot - 1;
            }
        }
        return nums[k];
    }

    private int part(int[] nums, int lower, int higher) {
        int pivot = lower + (higher - lower) / 2;

        while (lower < higher) {
            while (pivot > lower && nums[lower] >= nums[pivot]) {
                lower++;
            }
            while (pivot < higher && nums[pivot] >= nums[higher]) {
                higher--;
            }
            if (lower != higher) {
                swap(nums, lower, higher);
            }

            if (lower == pivot) {
                pivot = higher;
            } else if (higher == pivot) {
                pivot = lower;
            } else {
                lower++;
                higher--;
            }
        }
        return pivot;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
