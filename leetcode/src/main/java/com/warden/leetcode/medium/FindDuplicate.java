package com.warden.leetcode.medium;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/26
 */
public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3};


	}

	public int findDuplicate(int[] nums) {
		//快慢指针
		int slow = 0;
		int fast = nums[1];

		do {
			slow = nums[slow];
			fast = nums[fast];
			fast = nums[fast];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return nums[slow];
	}

}
