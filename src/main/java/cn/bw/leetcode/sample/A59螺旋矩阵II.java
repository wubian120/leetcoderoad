package cn.bw.leetcode.sample;


/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/submissions/
 */
public class A59螺旋矩阵II {

    public int cur = 1;//当前值
    public int[][] generateMatrix(int n) {
        cur = 1;
        int[][] m = new int[n][n];
        for(int i =0, j=n-1 ; i<=j; i++, j--) {
//        	System.out.println(String.format("i是：%d, j是：%d", i,j));
            setMatrixBoundaryValue(m, i, i,j, j);//设置由这两个点组成的一个矩阵的最外层的值
        }

        return m;
    }

    //设置由这两个点组成的一个矩阵的最外层的值
    public void setMatrixBoundaryValue(int[][] m, int strX, int strY, int endX, int endY) {
        if(strX == endX) {//最后如果只剩一个数了
            m[strX][strY] = cur++;
            return;
        }

        for(int j = strY; j<endY; j++) //注意不走到底,防止有重复数据
            m[strX][j] = cur++;
        for(int i = strX; i<endX; i++)
            m[i][endY] = cur++;
        for(int j = endY; j>strY; j--)
            m[endX][j] = cur++;
        for(int i = endX; i>strX; i--)
            m[i][strY] = cur++;
    }

}
