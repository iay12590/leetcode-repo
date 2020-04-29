package com.warden.leetcode.daily;

import com.warden.leetcode.common.struct.MountainArray;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class FindInMountainArray {

	public static void main(final String[] args) {
		final int[] array = {1,5,2};
		MountainArray mountainArray = new MountainArray() {
			public int get(int index) {
				return array[index];
			}

			public int length() {
				return array.length;
			}
		};
		System.out.println(new FindInMountainArray().findInMountainArray(0, mountainArray));
	}

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int len = mountainArr.length();
		int left = 0;
		int right = len -1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
				left = mid +1;
			} else {
				right = mid;
			}
		}
		int top = left;
		left = 0;
		right = top;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int midValue = mountainArr.get(mid);
			if (midValue == target) {
				return mid;
			}
			if (midValue > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		left = top;
		right = len - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int midValue = mountainArr.get(mid);
			if (midValue == target) {
				return mid;
			}
			if (midValue > target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
