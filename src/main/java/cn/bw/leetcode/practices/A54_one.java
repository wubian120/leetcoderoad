package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/8 12:33
 */
public class A54_one {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new LinkedList<>();

        if(matrix.length==0 || matrix[0].length==0){
            return results;
        }
        int m = matrix.length, n = matrix[0].length;
        int dx = 0, dy = 1, x = 0, y = 0;

        while (results.size() < n * m) {
            results.add(matrix[x][y]);
            matrix[x][y] = 0;
            if (x + dx < 0 || y + dy < 0 || x + dx > m || y + dy > n || matrix[x + dx][y + dy] == 0) {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
            x += dx;
            y += dy;
        }
        return results;
    }

}
