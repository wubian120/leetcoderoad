package cn.bw.leetcode.practices;

public class A41缺失的第一个正数s {


    /***
     *
     * @beat   95%
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int index = 0, len = nums.length;
        while (index < len) {
            // 最后一个， 前一个数与当前数相等
            if (nums[index] <= 0 || nums[index] > len || nums[nums[index] - 1] == nums[index]){
                index++;
            }else {
                swap(nums,index, nums[index]-1);
            }
        }
        int i=0;
        while (i<len && nums[i]==i+1){
            i++;
        }
        return i+1;
    }
    private void swap(int[] d, int i,int j){
        d[i] = d[i] ^ d[j];
        d[j] = d[i] ^ d[j];
        d[i] = d[i] ^ d[j];
    }


    public static void main(String...args){

        int[] nums = {0,3,4};
        A41缺失的第一个正数s a = new A41缺失的第一个正数s();


        int result = a.firstMissingPositive(nums);

        System.out.println(result);
    }
}
