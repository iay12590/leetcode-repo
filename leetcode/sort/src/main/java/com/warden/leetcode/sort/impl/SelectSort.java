package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.AbstractSort;

import static com.warden.leetcode.sort.util.SortUtils.exch;
import static com.warden.leetcode.sort.util.SortUtils.less;

/**
 * 选择排序
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class SelectSort extends AbstractSort {

	private int n;

	public SelectSort(int n) {
		this.n = n;
	}

	@Override
	public Comparable[] sort(Comparable[] arr) {
		int len = arr.length;
		for (int i =0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (less(arr[i], arr[j])) {
					exch(arr, i, j);
				}
			}
		}
		return arr;
	}

	@Override
	public int getCount() {
		return n;
	}
}
