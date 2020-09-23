package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.AbstractSort;
import com.warden.leetcode.sort.util.SortUtils;

/**
 * 插入排序：
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class InsertionSort extends AbstractSort {

	private int count;

	public InsertionSort(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Comparable[] sort(Comparable[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j >= 1; j--) {
				if (SortUtils.less(arr[j-1], arr[j])) {
					SortUtils.exch(arr, j-1, j);
				} else {
					break;
				}
			}
		}
		return arr;
	}
}
