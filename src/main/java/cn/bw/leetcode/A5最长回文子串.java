package cn.bw.leetcode;

/**
 * @description:
 * todo
 * @auther: bian.wu
 * @date: 2019/4/27 23:54
 */
public class A5最长回文子串 {

    public String longestPalindrome(String s){

        if(s==null || s.length()<=0){
            return "";
        }
        int len = s.length(), start=0, currentBest=1;
        boolean[][] dp = new boolean[len][len];
        char[] cs = s.toCharArray();
        for(int i=0;i<len;i++){
            dp[i][i] =true;
        }
        for(int i=0;i<len-1;i++){
            if(cs[i] == cs[i+1]){
                dp[i][i+1]=true;
                start=i;
                currentBest = 2;
            }
        }

        for(int l=3;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j = i+l-1;

                if((dp[i+1][j-1])&&(cs[i] == cs[j])){
                    dp[i][j]=true;
                    start=i;
                    currentBest = Math.max(currentBest,l);
                }

            }
        }

        return s.substring(start,start+currentBest);
    }


}
