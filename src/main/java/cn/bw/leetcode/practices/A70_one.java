package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/21 23:58
 */
public class A70_one {

    public int climbStairs(int n){
        if(n<=2) return n;

        int[] dp = new int[n+1];
        for(int i=0;i<=2;i++){
            dp[i] =i;
        }
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
