package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/28 10:42
 */
public class A96_two {


    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }



}
