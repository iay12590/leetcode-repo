package com.warden.leetcode.daily;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/28
 */
public class FindNumCount {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3};
		nums = new FindNumCount().singleNumbers(nums);
		System.out.println(Arrays.toString(nums));
	}

	public int[] singleNumbers(int[] nums) {

		//异或， 相同为0，不同为1，并且0^a = a
		//1 找出nums异或值，比如是0x10001，这个值肯定不为0，从右找出第一个非0位，将数值分为两部分求异或
		//2 本来相同分到同一个数组，不同的数分到不同的数组，分别求异或
		if (nums == null || nums.length < 2) {
			return null;
		}
		int ret = 0;
		for (int num1 : nums) {
			ret ^= num1;
		}
		int index = 0;
		while ((ret & 1) == 0) {
			index += 1;
			ret >>= 1;
		}
		int r1 = 0;
		int r2 = 0;
		for (int num : nums) {
			if (((num >> index) & 1) == 0) {
				r1 ^= num;
			} else {
				r2 ^= num;
			}
		}
		return new int[]{r1, r2};
	}
}
