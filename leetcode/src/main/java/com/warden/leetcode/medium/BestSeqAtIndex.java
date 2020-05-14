package com.warden.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/13
 */
public class BestSeqAtIndex {

	public static void main(String[] args) {
		int[] height = {65,70,56,75,60,68};
		int[] weight = {100,150,90,190,95,110};
		System.out.println(new BestSeqAtIndex().bestSeqAtIndex(height, weight));
	}

	public int bestSeqAtIndex(int[] height, int[] weight) {
		if (height == null) {
			return 0;
		}
		int len = height.length;
		if (len <= 1) {
			return len;
		}
		int[][] array = new int[len][2];
		for (int i = 0; i < len;i++) {
			array[i][0] = height[i];
			array[i][1] = weight[i];
		}
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});

		Set<Integer> temp = new HashSet<>();
		int[] tail = new int[len];
		int size = 0;
		for (int i = 0; i < len; i++) {
			int left = 0;
			int right = size;
			while (left != right) {
				int mid = (left + right) >> 1;
				if (tail[mid] < array[i][1]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			tail[left] = array[i][1];
			if (left == size) {
				size++;
			}
		}
		return size;
	}

}
