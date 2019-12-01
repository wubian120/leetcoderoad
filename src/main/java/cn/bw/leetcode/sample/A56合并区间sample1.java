package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A56合并区间sample1 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        // 实现Comparator接口进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 由于排过序了，则intervals[i][0] 一定不小于left，所以只需要比较intervals[i][0]和right的大小关系
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                // 无重叠部分，先把上一段区间加到list中
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void main(String...args){

        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        A56合并区间sample1 a = new A56合并区间sample1();
        int[][]results = a.merge(nums);

        System.out.println("end");


    }


}
