package com.warden.leetcode.head;

import java.util.Arrays;

/**
 * 最大堆
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/29
 */
public class KthLargest {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest();
		int[] nums = {1,3,1,6,4,7,3,14,13};
		for (int i = 0; i < nums.length; i++) {
			System.out.println(kthLargest.findKthLargest(nums, i));
		}
		System.out.println(Arrays.toString(nums));
	}

	public int findKthLargest(int[] nums, int k) {
		buildHeap(nums);
		int len = nums.length;
		for (int i = 1; i <= k-1; i++) {
			swap(nums, 0, len - i);
			adjust(nums, 0, len - i - 1);
		}
		return nums[0];
	}

	private void buildHeap(int[] nums) {
		int len = nums.length;
		for (int i = len >> 1; i >= 0; i--) {
			adjust(nums, i, len - 1);
		}
	}

	private void adjust(int[] nums, int index, int boundary) {
		int left = (index << 1) + 1;
		int right = (index+1) << 1;
		if (left <= boundary && nums[index] < nums[left]) {
			swap(nums, index, left);
			adjust(nums, left, boundary);
		}
		if (right <= boundary && nums[index] < nums[right]) {
			swap(nums, index, right);
			adjust(nums, right, boundary);
		}
	}



	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
