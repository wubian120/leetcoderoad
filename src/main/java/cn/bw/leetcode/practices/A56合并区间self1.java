package cn.bw.leetcode.practices;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/***
 * leetcode 56 合并区间 self first time
 * copy writing
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 */
public class A56合并区间self1 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> tempList = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= right) {
                right = Math.max(intervals[i][1], right);
            } else {
                //无重叠
                tempList.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }

        }

        tempList.add(new int[]{left,right});
        int[][] result = new int[tempList.size()][2];
        for(int i=0;i<tempList.size();i++){
            result[i] = tempList.get(i);
        }
        return result;

    }


}
