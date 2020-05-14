package com.warden.leetcode.dp.lis;

/**
 * 最长上升子串
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/13
 */
public class LongestIncreasingSubsequence {

	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int len = nums.length;
		if (len <= 0) {
			return len;
		}
		int[] dp = new int[len];
		dp[0] = 1;
		int res = 1;
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public int greedy(int[] nums) {
		int len = nums.length;
		//保存当前最优化的lis
		//比如[1,2,5,7,3...],在i=3时，lis为1,2,5,7，i=4时，num=3,
		// 此时使用3替换第一个比3大的值，因为以125为前缀的肯定能以123为前缀，保存123即可，7不变
		int[] lis = new int[len];

		//有效长度
		int size = 0;
		for (int i = 0; i < len; i++) {
			int j = 0;
			int k = size;
			while (j != k) {
				int mid = (j+k) >> 1;
				if (lis[mid] < nums[i]) {
					j = mid + 1;
				} else {
					k = mid;
				}
			}
			lis[j] = nums[i];
			if (j == size) {
				size++;
			}
		}
		return size;
	}

}
