package com.warden.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/12
 */
public class SmallestDistance {

	public static void main(String[] args) {
		int[] nums = {62, 100, 4};
		new SmallestDistance().smallestDistancePair(nums, 2);
	}

	public int smallestDistancePair(int[] nums, int k) {
		//二分
		int len = nums.length;
		Arrays.sort(nums);
		int left = 0;
		int right = nums[len - 1] - nums[0];
		while (left < right) {
			int mid = (left+right) >> 1;
			int count = 0;
			int j = 0;
			for (int i = 0; i < nums.length; i++) {
				// 查找 nums[i] - nums[j] <= mid的数量，慢慢缩小差距获取符合范围[j, i]
				while (nums[i] - nums[j] > mid) {
					j++;
				}
				count += i - j;
			}
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
