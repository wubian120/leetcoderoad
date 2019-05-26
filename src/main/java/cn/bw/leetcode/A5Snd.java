package cn.bw.leetcode;

/**
 * @description: 5 最长回文子串  passed
 * @auther: bian.wu
 * @date: 2019/3/18 13:05
 */
public class A5Snd {
    public static  String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2 || s == null) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int maxlen = 0;
        int beg = 0;
        for (int i = 0; i < len; i++) {
            //dp解题，初始化dp状态数组
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 < len && i - 1 >= 0 && (dp[j + 1][i - 1] == true || i - j == 1)) {
                        //注意！i-j==1小细节，一开始不过就是因为没有考虑它
                        dp[j][i] = true;
                        if (maxlen < i - j + 1) {
                            maxlen = i - j + 1;
                            beg = j;
                        }
                    }
                }
            }
        }
        if (maxlen == 0 && beg == 0) {
            return s.charAt(0) + "";
        }
        return s.substring(beg, beg + maxlen);


    }


    public static void main(String... args) {
        String s = "babad";
//        String s = "ac";


        String result = A5Snd.longestPalindrome(s);
        System.out.println(result);
        System.out.println("end");

    }


}
