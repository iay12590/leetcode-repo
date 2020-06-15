package com.warden.leetcode.bitvoting;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/2
 */
public class BitVoting {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3};
		new BitVoting().getConfictNum(nums);
	}

	private void getConfictNum(int[] nums) {

		int maxBit = 31;
		int n = nums.length;

		while ((n - 1) >> maxBit == 0) {
			maxBit-=1;
		}
		System.out.println(maxBit);
		int ans = 0;
		for (int bit = 0; bit <= maxBit; bit++) {
			int x = 0, y = 0;
			for (int i = 0; i < n; ++i) {
				if ((nums[i] & (1 << bit)) != 0) {
					x += 1;
				}
				if (i >= 1 && ((i & (1 << bit)) != 0)) {
					y += 1;
				}
			}
			if (x > y) {
				ans |= 1 << bit;
			}
		}
		System.out.println(ans);
	}

}
