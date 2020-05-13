package com.warden.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/12
 */
public class SmallestSums {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int[] moveCache = new int[nums1.length];
		List<List<Integer>> res = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			int minIndex = 0;
			Integer min = Integer.MAX_VALUE;
			for (int j = 0; j < nums1.length; j ++) {
				if (moveCache[j] < nums2.length) {
					int tmp = nums1[j] + nums2[moveCache[j]];
					if (tmp < min) {
						minIndex = j;
						min = tmp;
					}
				}
			}
			if (moveCache[minIndex] >= nums2.length) {
				break;
			}
			List<Integer> list = new ArrayList<>(2);
			list.add(nums1[minIndex]);
			list.add(nums2[moveCache[minIndex]]);
			res.add(list);
			moveCache[minIndex]++;
		}
		return res;
	}

}
