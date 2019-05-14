package cn.bw.leetcode;

/***
 * 64 最小路径和  dp
 *
 */
public class A64最小路径和 {

    public int minPathSum(int[][] grid) {

        // rows 行数
        int rows = grid.length;
        //cols  列数
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        //如果一只往右走
        for(int c=1;c<cols;c++){
            dp[0][c] = grid[0][c] + dp[0][c-1];
        }
        //如果一直往下走
        for(int r=1;r<rows;r++){
            dp[r][0] = grid[r][0] + dp[r-1][0];
        }

        for(int r=1;r<rows;r++){
            for(int c=1;c<cols;c++){
                // 状态迁移公式， dp值 = 当前网格值  +  上一行 同列值与本行上一列值 中较小的那个
                dp[r][c] = grid[r][c] + Math.min(dp[r-1][c],dp[r][c-1]);
            }
        }
        return dp[rows-1][cols-1];
    }
}
