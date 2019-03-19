package cn.bw.leetcode;

/**
 * @description: 44 通配符匹配
 * @题目: https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * @思路: DP，  dp[][]
 * @auther: bian.wu
 * @date: 2019/3/18 14:16
 */
public class A44Fst {

    public static boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // 空字符串
        dp[0][0] = true;
        // s 不为空， p为空
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = false;
        }
        // s空， p不空
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = (p.charAt(i-1) == '*' && dp[0][i-1]);
        }
        for (int j = 1; j <= len2; j++) {
            for (int i = 1; i <= len1; i++) {
                //j-1 不为 *
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '?' == p.charAt(j - 1));
                } else {
                    // j-1 = '*'
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String... args) {

//        String s = "aa";
//        String p = "a";

//        String s = "aa";
//        String p = "*";

//        String s = "cb";
//        String p = "?a";

        String s = "adceb";
        String p = "*a*b";

        boolean isMatch = A44Fst.isMatch(s,p);

        System.out.println(isMatch);
    }

}
