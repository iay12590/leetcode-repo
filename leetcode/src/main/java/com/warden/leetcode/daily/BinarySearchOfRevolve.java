package com.warden.leetcode.daily;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/27
 */
public class BinarySearchOfRevolve {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(new BinarySearchOfRevolve().search(nums, 5));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int begin = 0;
		int end = nums.length - 1;
		while (begin <= end) {

			int mid = (begin + end) >> 1;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] < nums[end]) {
				//右边有序，对mid-end进行二分
				if (target > nums[mid] && target <= nums[end]) {
					//在右边
					begin = mid + 1;
				} else {
					//在左边
					end = mid - 1;
				}
			} else {
				//左边有序begin-end进行二分
				if (target >= nums[begin] && target < nums[mid]) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}
		}
		return -1;
	}
}
