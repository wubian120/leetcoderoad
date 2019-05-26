package cn.bw.leetcode;

/**
 * @description: leetcode 887 鸡蛋掉落
 * @题目： https://leetcode-cn.com/problems/super-egg-drop/
 *
 * @思路： 动态规划  O(nlogn)  优化后 O(n)
 *
 * @参考： https://juejin.im/post/5c88bdbc5188257b050d75c2#heading-8
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/15 17:29
 */
public class A887Fst {

    /**k个蛋， N层楼*/
    public static int superEggDrop(int k, int n) {

        if(k == 1 || n<=2){
            return n;
        }
        int[][] dp = new int[k][n+1];
        for(int i=0;i<k;i++){
            dp[i][0] = 0;
            dp[i][1] =1;
            dp[i][2] = 2;
        }
        for(int j=3;j<=n;j++){
            dp[0][j] = j;
        }


        // dp[i][j] i个蛋， j层楼 最大步
        for(int i=1;i<k;i++){

            int x = 1;
            for(int j=3;j<=n; j++){
                if(dp[i-1][x-1] < dp[i][j-x] ){
                    x++;
                }
                dp[i][j] = dp[i-1][x-1] + 1;
            }


        }
        return dp[k-1][n];
    }


    public static void main(String...args){

        int k1 =1, n1=2;
        int k2 = 2, n2 = 6;
        int k3 = 3, n3 = 14;

        int result =  A887Fst.superEggDrop( k2,n2);

        System.out.println(result);

    }



}
