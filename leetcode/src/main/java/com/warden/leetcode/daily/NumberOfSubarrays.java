package com.warden.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k。

 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

 请返回这个数组中「优美子数组」的数目。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/21
 */
public class NumberOfSubarrays {
	public static void main(String[] args) {
		int[] nums = {1,1, 2,1,1};
		int k = 3;
		System.out.println(new NumberOfSubarrays().numberOfSubarrays(nums, k));
	}
	public int numberOfSubarrays(int[] nums, int k) {
		int len = nums.length;
		for (int i=0; i<len; i++) {
			if ((nums[i] & 1) == 1) {
				nums[i] = 1;
			} else {
				nums[i] = 0;
			}
		}
		Map<Long, Integer> mp = new HashMap<Long, Integer>();
		long sum = 0;
		mp.put(0L, 1);
		int res = 0;
		for (int i=1; i<=len; i++) {
			sum += nums[i-1];
			// sum - k = x
			Integer even = mp.get(sum - k);
			res += (even == null ? 0 :even);
			mp.put(sum, mp.get(sum) == null ? 1 : mp.get(sum) +1);
		}
		return res;
	}
}
