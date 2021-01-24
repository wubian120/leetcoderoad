package cn.bw.leetcode.practices;

/***
 * leetcode 跳跃游戏
 * 
 * https://leetcode-cn.com/problems/jump-game/submissions/
 */
public class A55跳跃游戏 {

    public boolean canJump(int[] nums) {

        int step = 1;
        for(int i=nums.length-2;i>=0;i--){
            step = (nums[i]>=step ? 1:step+1);
        }

        return step==1;
    }
}
