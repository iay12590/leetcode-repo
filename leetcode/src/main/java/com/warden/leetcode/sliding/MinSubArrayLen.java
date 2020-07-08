package com.warden.leetcode.sliding;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/28
 */
public class MinSubArrayLen {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(new MinSubArrayLen().minSubArrayLen(7, nums));
	}

	public int minSubArrayLen(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int sum = 0;
		while (right < nums.length) {
			sum += nums[right++];
			while (sum >= s) {
				if (left <= right) {
					min = Math.min(right - left, min);
				}
				sum -=  nums[left++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
