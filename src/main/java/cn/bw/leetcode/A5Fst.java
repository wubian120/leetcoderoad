package cn.bw.leetcode;

/**
 * @description: 5. 最长回文子串 passed
 * @auther: bian.wu
 * @date: 2019/3/17 20:12
 */
public class A5Fst {

    public static String longestPalindrome(String s) {
        int currentBest = 1;
        int start = 0;
        int len = s.length();
        if (s == null || len == 0) {
            return "";
        }
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                currentBest = 2;
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (l > currentBest) {
                        currentBest = l;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + currentBest);
    }

    public static void main(String... args) {
        String s = "babad";
//        String s = "ac";
        A5Fst a5one = new A5Fst();

        String result = A5Fst.longestPalindrome(s);
        System.out.println(result);
        System.out.println("end");

    }

}
