package com.warden.leetcode.dp.greedy.intervalschedule;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2020/5/4 0004.
 * 区间调度
 */
public class IntervalSchedule {

    public int maxNonintersect(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int endTemp = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start >= endTemp) {
                count++;
                endTemp = intervals[i][1];
            }
        }
        return count;
    }

}
