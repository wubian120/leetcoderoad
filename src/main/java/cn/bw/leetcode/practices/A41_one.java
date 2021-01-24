package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/30 20:46
 */
public class A41_one {


    public int firstMissingPositive(int[] nums) {

        int index = 0, len = nums.length;
        while (index<len){

            if(nums[index] <=0 || nums[index] > len || nums[index] == nums[nums[index]-1] ){
                index++;
            }else {
                swap(nums, index, nums[index]-1);
            }

        }

        int i=0;
        while (i<len && nums[i] == i+1){
            i++;
        }

        return i-1;
    }

    private void swap(int[] d, int i,int j){
        d[i] = d[i] ^d[j];
        d[j] = d[i] ^d[j];
        d[i] = d[i] ^d[j];
    }

}
