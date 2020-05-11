package com.warden.leetcode.sort;

/**
 * 有多少小于当前数字的数字
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/9
 */
public class SmallerNumbersThanCurrent {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return nums;
		}
		int[] count = new int[101];
		for (int num : nums) {
			count[num]++;
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = 0; j < nums[i]; j++) {
				sum+=count[j];
			}
			nums[i] = sum;
		}
		return nums;
	}
}
