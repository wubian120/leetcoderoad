package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/23 09:43
 */
public class A169_one {

    public int majorityElement(int[] nums){

        int count =0, result = nums[0], len = nums.length/2;
        for(int number : nums){
            if(number == result){
                count++;
                if(count>len){
                    return result;
                }
            }else {
                count--;
                if(count==0){
                    result=number;
                    count=1;
                }
            }
        }
        return result;
    }

}
