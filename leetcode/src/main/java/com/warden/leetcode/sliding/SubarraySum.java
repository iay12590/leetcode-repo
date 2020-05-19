package com.warden.leetcode.sliding;

import java.util.HashMap;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/15
 */
public class SubarraySum {

	public static void main(String[] args) {
		int[] nums = {3,4,7,2-3,1,4,2};
		int k = 7;
		System.out.println(new SubarraySum().subarraySum(nums, k));
	}

	public int subarraySum(int[] nums, int k) {
		int count = 0, pre = 0;
		HashMap< Integer, Integer > mp = new HashMap < > ();
		mp.put(0, 1);
		for (int num : nums) {
			pre += num;
			if (mp.containsKey(pre - k)) {
				count += mp.get(pre - k);
			}
			mp.put(pre, mp.getOrDefault(pre, 0) + 1);
		}
		return count;
	}
}
