package com.warden.leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 * Created by Administrator on 2020/5/4 0004.
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            int[] last = result.get(result.size() - 1);
            if (last[1] >= cur[0]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                result.add(cur);
            }
        }
        int[][] arr = new int[result.size()][];
        return result.toArray(arr);
    }

}
