package com.warden.leetcode.sliding;

import java.util.Arrays;

/**
 *
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/12
 */
public class MaxSlidingWindow {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(nums, k)));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0 || nums == null) {
			return null;
		}
		return dp2(nums, k);
	}

	private int[] dp2(int[] nums, int k) {
		int len = nums.length;
		int[] left = new int[len];
		int[] right = new int[len];
		for (int i = 0; i < len; i++) {
			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(nums[i], left[i-1]);
			}
		}
		right[len - 1] = nums[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			if ((i+1) % k == 0) {
				right[i] = nums[i];
			} else {
				right[i] = Math.max(nums[i], right[i+1]);
			}
		}
		int[] res = new int[len - k + 1];
		for (int i = 0; i < len - k + 1; i++) {
			res[i] = Math.max(right[i], left[Math.min(i + k- 1, len -1)]);
		}
		return res;
	}
	private int[] dp(int[] nums, int k) {
		int[] dp = new int[nums.length];
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				if (j == 0 || i == 0) {
					dp[j] = nums[j];
				} else {
					dp[j] = Math.max(nums[j], dp[j-1]);
				}
			}
		}
		int[] res = new int[nums.length - k + 1];
		System.arraycopy(dp, k - 1, res, 0, res.length);
		return res;
	}

}
