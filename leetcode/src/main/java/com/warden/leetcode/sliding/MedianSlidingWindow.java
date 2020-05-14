package com.warden.leetcode.sliding;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口中值
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/14
 */
public class MedianSlidingWindow {

	public static void main(String[] args) {
		int[] nums = {1};
		int k = 1;
		System.out.println(Arrays.toString(new MedianSlidingWindow().medianSlidingWindow(nums, k)));
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return null;
		}
		int len = nums.length;
		if (len <= 2 || len < k) {
			return null;
		}
		double[] res = new double[len - k + 1];
		LinkedList<Integer> indexList = new LinkedList<>();
		int[] sorts = new int[k];
		for (int i = 0; i < k; i++) {
			sorts[i] = nums[i];
			int origin = i;
			for (int j = i -1; j >= 0; j--) {
				if (sorts[j] > sorts[origin]) {
					exchange(sorts, j, origin);
					origin = j;
				}
			}
			indexList.add(origin);
		}
		res[0] = (double) (sorts[(k-1)/2] + sorts[(k)/2]) / 2;
		for (int i = k; i < len; i++) {
			//替换sorts
			int removeIndex = index(sorts, nums[i-k]);
			sorts[removeIndex] = nums[i];
			int origin = removeIndex;
			boolean isLeft = false;
			for (int j = removeIndex -1; j >= 0; j--) {
				if (sorts[j] > sorts[origin]) {
					exchange(sorts, j, origin);
					origin = j;
					isLeft = true;
				} else {
					break;
				}
			}
			if (!isLeft) {
				for (int j = removeIndex + 1; j < k; j++) {
					if (sorts[j] < sorts[origin]) {
						exchange(sorts, j, origin);
						origin = j;
					} else {
						break;
					}
				}
			}
			res[i-k+1] = (double) (sorts[(k-1)/2] + sorts[(k)/2]) / 2;
		}
		return res;
	}

	private void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int index(int[] nums, int value) {
		int left = 0;
		int right = nums.length - 1;
		while (left<=right) {
			int mid = (right + left) >> 1;
			if (nums[mid] == value) {
				return mid;
			} else if (nums[mid] > value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
