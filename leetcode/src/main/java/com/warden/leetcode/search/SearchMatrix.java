package com.warden.leetcode.search;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/12
 */
public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int xlen = matrix.length;
		int ylen = matrix[0].length;
		if (ylen == 0) {
			return false;
		}
		int left = 0;
		int right = xlen * ylen - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int vmid = matrix[mid / ylen][mid % ylen];
			if (vmid == target) {
				return true;
			} else if (vmid > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

}
