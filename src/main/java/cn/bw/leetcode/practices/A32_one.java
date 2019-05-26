package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/19 10:53
 */
public class A32_one {


    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length(), max = 0;

        int[] dp = new int[len];
        for (int index = len - 2; index >= 0; index--) {
            int symIndex = index + 1 + dp[index + 1];
            if ('(' == s.charAt(index) && symIndex < len && ')' == s.charAt(symIndex)) {
                dp[index] = dp[index + 1] + 2;
                if (symIndex + 1 < len) {
                    dp[index] += dp[symIndex + 1];
                }
            }
            max = Math.max(max, dp[index]);
        }
        return max;
    }


    public int longestValidParentheses_one(String s) {

        if (s == null) return 0;

        int len = s.length(), max = 0;
        int[] dp = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int symI = i + 1 + dp[i + 1];
            if ('(' == s.charAt(i) && symI < len && ')' == s.charAt(symI)) {
                dp[i] = dp[i + 1] + 2;
                if (symI + 1 < len) {
                    dp[i] += dp[symI + 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
